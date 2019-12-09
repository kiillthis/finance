package com.netcracker.services.impl;

import com.netcracker.dao.CreditAccountDao;
import com.netcracker.dao.CreditDeptDao;
import com.netcracker.dao.CreditOperationDao;
import com.netcracker.dao.PersonalDebitAccountDao;
import com.netcracker.models.CreditOperation;
import com.netcracker.models.Debt;
import com.netcracker.models.PersonalCreditAccount;
import com.netcracker.models.PersonalDebitAccount;
import com.netcracker.models.enums.CreditStatusPaid;
import com.netcracker.services.utils.CreditUtils;
import com.netcracker.services.PersonalCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

@Service
public class PersonalCreditServiceImpl implements PersonalCreditService {

    @Autowired
    CreditAccountDao creditAccountDao;

    @Autowired
    CreditOperationDao creditOperationDao;

    @Autowired
    PersonalDebitAccountDao debitAccountDao;

    @Autowired
    CreditDeptDao creditDeptDao;

    @Override
    public void createPersonalCredit(BigInteger id, PersonalCreditAccount creditAccount) {
        creditAccountDao.createPersonalCreditByDebitAccountId(id, creditAccount);
    }

    @Override
    public void deletePersonalCredit(BigInteger id) {
        creditAccountDao.updateIsPaidStatusPersonalCredit(id, CreditStatusPaid.YES);
    }

    @Override
    public void addPersonalCreditPayment(BigInteger idAccount, BigInteger idCredit, long amount) {
        PersonalCreditAccount creditAccount = getPersonalCreditAccount(idCredit);
        addPayment(creditAccount, idAccount, amount);
    }

    @Override
    public void addPersonalCreditPaymentAuto(BigInteger idAccount, BigInteger idCredit, long amount) {
        PersonalCreditAccount creditAccount = getPersonalCreditAccount(idCredit);
        PersonalDebitAccount debitAccount = debitAccountDao.getPersonalAccountById(idAccount);
        if (debitAccount.getAmount() < amount) {
            increaseDebt(creditAccount.getDebt(), amount);
        } else {
            if (creditAccount.getDebt().getDateFrom() != null) {
                decreaseDebt(creditAccount.getDebt(), amount);
            }
            addPayment(creditAccount, idAccount, amount);
        }
    }

    private void increaseDebt(Debt debt, long amount) {
        if (debt.getDateFrom() == null) {
            debt.setDateFrom(LocalDate.now());
            changeDebtDateFrom(debt.getDebtId(), debt.getDateFrom());
            changeDebtAmount(debt.getDebtId(), amount);
        }
        LocalDate newDateTo = CreditUtils.addMonthsToDate(debt.getDateTo(), 1);
        changeDebtDateTo(debt.getDebtId(), newDateTo);
        changeDebtAmount(debt.getDebtId(), debt.getAmountDebt() + amount);
    }

    private void decreaseDebt(Debt debt, long amount) {
        LocalDate newDateFrom = CreditUtils.addMonthsToDate(debt.getDateTo(), 1);
        if (newDateFrom.equals(debt.getDateTo())) {
            changeDebtDateFrom(debt.getDebtId(), null);
            changeDebtDateTo(debt.getDebtId(), null);
            changeDebtAmount(debt.getDebtId(), 0);
        } else {
            changeDebtDateFrom(debt.getDebtId(), newDateFrom);
            changeDebtAmount(debt.getDebtId(), debt.getAmountDebt() + amount);
        }
    }

    @Override
    public Collection<PersonalCreditAccount> getPersonalCredits(BigInteger id) {
        return creditAccountDao.getAllPersonalCreditsByAccountId(id);
    }

    @Override
    public Collection<CreditOperation> getAllPersonalCreditOperations(BigInteger id) {
        return creditOperationDao.getAllCreditOperationsByCreditPersonalId(id);
    }

    @Override
    public PersonalCreditAccount getPersonalCreditAccount(BigInteger id) {
        return creditAccountDao.getPersonalCreditById(id);
    }

    @Override
    public long getMonthPaymentAmount(PersonalCreditAccount personalCreditAccount) {
        return CreditUtils.calculateMonthPayment(personalCreditAccount.getDate(),
                personalCreditAccount.getDateTo(),
                personalCreditAccount.getAmount(),
                personalCreditAccount.getCreditRate());
    }

    private void addPayment(PersonalCreditAccount creditAccount, BigInteger accountDebitId, long amount) {
        PersonalDebitAccount debitAccount = debitAccountDao.getPersonalAccountById(accountDebitId);
        long actualDebitAmount = debitAccount.getAmount();
        debitAccountDao.updateAmountOfPersonalAccount(accountDebitId, actualDebitAmount - amount);
//        creditOperationDao.createPersonalCreditOperation(new CreditOperation(amount, new Date()), creditAccount.getCreditId());
        creditOperationDao.createPersonalCreditOperation(amount, new Date(), creditAccount.getCreditId());
        long updatedAmount = creditAccount.getAmount() + amount;
        creditAccountDao.updatePersonalCreditPayment(creditAccount.getCreditId(), updatedAmount);
        if (creditAccount.getAmount() + amount == updatedAmount) {
            creditAccountDao.updateIsPaidStatusFamilyCredit(creditAccount.getCreditId(), CreditStatusPaid.YES);
        }
    }

    public void changeDebtDateTo(BigInteger id, LocalDate date) {
        creditDeptDao.updateFamilyDebtDateTo(id, CreditUtils.localDateToSqlDate(date));
    }

    public void changeDebtDateFrom(BigInteger id, LocalDate date) {
        creditDeptDao.updatePersonalDebtDateFrom(id, CreditUtils.localDateToSqlDate(date));
    }

    public void changeDebtAmount(BigInteger id, long amount) {
        creditDeptDao.updatePersonalDebtAmount(id, amount);
    }

}
