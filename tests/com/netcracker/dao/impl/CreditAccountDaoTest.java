package com.netcracker.dao.impl;

import com.netcracker.configs.WebConfig;
import com.netcracker.dao.CreditAccountDao;
import com.netcracker.models.*;
import com.netcracker.models.enums.CreditStatusPaid;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CreditAccountDaoTest {

    private AbstractCreditAccount personalCreditAccountOne;
    private AbstractCreditAccount familyCreditAccountOne;
    private AbstractCreditAccount personalCreditAccountEmpty;
    private AbstractCreditAccount familyCreditAccountEmpty;
    private List<AbstractCreditAccount> personalListCredits;
    private List<AbstractCreditAccount> familyListCredits;

    @Autowired
    private CreditAccountDao creditAccountDao;

    @Before
    public void initializeObjects() {
        personalListCredits = new ArrayList<>();
        familyListCredits = new ArrayList<>();
        Debt famDebtOne = new Debt.Builder()
                .amountDebt(0L)
                .dateFrom(LocalDate.of(2019, 11, 30))
                .dateTo(LocalDate.of(2020, 2, 28))
                .debtId(new BigInteger("15"))
                .build();

        Debt perDebtOne = new Debt.Builder()
                .debtId(new BigInteger("14"))
                .amountDebt(0L)
                .dateFrom(LocalDate.of(2019, 11, 30))
                .dateTo(LocalDate.of(2020, 2, 28))
                .build();

        familyCreditAccountOne =
                new FamilyCreditAccount.Builder()
                        .creditId(new BigInteger("11"))
                        .name("Credit_Money1")
                        .amount(15000L)
                        .paidAmount(3000L)
                        .creditRate(20L)
                        .date(LocalDate.of(2019, 11, 30))
                        .dateTo(LocalDate.of(2020, 2, 28))
                        .monthDay(1)
                        .isPaid(CreditStatusPaid.getStatusByKey(new BigInteger("38")))
                        .debtCredit(famDebtOne)
                        .build();

        personalCreditAccountOne =
                new PersonalCreditAccount.Builder()
                        .creditId(new BigInteger("10"))
                        .name("Credit_Money1")
                        .amount(10000L)
                        .paidAmount(2000L)
                        .date(LocalDate.of(2019, 11, 30))
                        .creditRate(20L)
                        .dateTo(LocalDate.of(2020, 2, 28))
                        .monthDay(1)
                        .isPaid(CreditStatusPaid.getStatusByKey(new BigInteger("38")))
                        .debtCredit(perDebtOne)
                        .build();

        personalCreditAccountEmpty =
                new PersonalCreditAccount.Builder()
                        .name("Credit_Money")
                        .amount(20000L)
                        .paidAmount(0L)
                        .date(LocalDate.now())
                        .creditRate(10L)
                        .dateTo(LocalDate.of(2020, 5, 7))
                        .monthDay(3)
                        .isPaid(CreditStatusPaid.getStatusByKey(new BigInteger("38")))
                        .debtCredit(new Debt.Builder().amountDebt(0L).build())
                        .build();

        familyCreditAccountEmpty =
                new FamilyCreditAccount.Builder()
                        .name("Credit_Money")
                        .amount(1000L)
                        .paidAmount(0L)
                        .date(LocalDate.now())
                        .creditRate(12L)
                        .dateTo(LocalDate.of(2020, 6, 7))
                        .monthDay(3)
                        .isPaid(CreditStatusPaid.getStatusByKey(new BigInteger("38")))
                        .debtCredit(new Debt.Builder().amountDebt(0L).build())
                        .build();

        personalListCredits.add(personalCreditAccountOne);
        familyListCredits.add(familyCreditAccountOne);

    }

    @Test
    public void getPersonalCreditByIdTest() {
        checkEqualsCredit(personalCreditAccountOne, creditAccountDao.getPersonalCreditById(new BigInteger("10")));
    }

    @Test
    public void getFamilyCreditByIdTest() {
        checkEqualsCredit(familyCreditAccountOne, creditAccountDao.getFamilyCreditById(new BigInteger("11")));
    }

    @Test
    public void getAllPersonalCreditByAccountId() {
        List<PersonalCreditAccount> listResult = creditAccountDao.getAllPersonalCreditsByAccountId(new BigInteger("2"));
        assertEquals(personalListCredits.size(), listResult.size());
        for (int i = 0; i < personalListCredits.size(); i++) {
            checkEqualsCredit(personalListCredits.get(i), listResult.get(i));
        }
    }

    @Test
    public void getAllFamilyCreditByAccountId() {
        List<FamilyCreditAccount> listResult = creditAccountDao.getAllFamilyCreditsByAccountId(new BigInteger("3"));
        for (int i = 0; i < familyListCredits.size(); i++) {
            checkEqualsCredit(familyListCredits.get(i), listResult.get(i));
        }
    }

    @Rollback
    @Test
    public void updatePersonalCreditPaymentTest() {
        double newAmount = personalCreditAccountOne.getPaidAmount();
        BigInteger accId = personalCreditAccountOne.getCreditId();

        creditAccountDao.updatePersonalCreditPayment(accId, newAmount);

        assertEquals(personalCreditAccountOne.getAmount(), creditAccountDao.getPersonalCreditById(accId).getAmount());
    }

    @Rollback
    @Test
    public void updateFamilyCreditPayment() {
        double newAmount = familyCreditAccountOne.getPaidAmount();
        BigInteger accId = familyCreditAccountOne.getCreditId();

        creditAccountDao.updateFamilyCreditPayment(accId, newAmount);

        assertEquals(familyCreditAccountOne.getAmount(), creditAccountDao.getFamilyCreditById(accId).getAmount());
    }

    @Rollback
    @Test
    public void updateIsPaidStatusPersonalCreditTest() {
        CreditStatusPaid statusPaid = CreditStatusPaid.NO;
        BigInteger creditId = personalCreditAccountOne.getCreditId();

        creditAccountDao.updateIsPaidStatusPersonalCredit(creditId, statusPaid);
        PersonalCreditAccount result = creditAccountDao.getPersonalCreditById(creditId);

        assertEquals(statusPaid, result.isPaid());
    }

    @Rollback
    @Test
    public void updateIsPaidStatusFamilyCreditTest() {
        CreditStatusPaid statusPaid = CreditStatusPaid.NO;
        BigInteger creditId = familyCreditAccountOne.getCreditId();

        creditAccountDao.updateIsPaidStatusFamilyCredit(creditId, statusPaid);
        FamilyCreditAccount result = creditAccountDao.getFamilyCreditById(creditId);

        assertEquals(statusPaid, result.isPaid());
    }

    @Rollback
    @Test
    public void createPersonalDebtByCreditIdTest() {
        BigInteger debitId = new BigInteger("2");
        int actualSize = creditAccountDao.getAllPersonalCreditsByAccountId(debitId).size();
        creditAccountDao.createPersonalCreditByDebitAccountId(debitId, (PersonalCreditAccount) personalCreditAccountEmpty);
        List<PersonalCreditAccount> result = creditAccountDao.getAllPersonalCreditsByAccountId(debitId);
        PersonalCreditAccount resultAccount = result.get(result.size() - 1);
        checkEqualsCredit(personalCreditAccountEmpty, resultAccount);
        assertEquals(actualSize + 1, result.size());
    }

    @Rollback
    @Test
    public void createFamilyDebtByCreditIdTest() {
        BigInteger debitId = new BigInteger("3");
        int actualSize = creditAccountDao.getAllFamilyCreditsByAccountId(debitId).size();
        creditAccountDao.createFamilyCreditByDebitAccountId(debitId, (FamilyCreditAccount) familyCreditAccountEmpty);
        List<FamilyCreditAccount> result = creditAccountDao.getAllFamilyCreditsByAccountId(debitId);
        FamilyCreditAccount resultAccount = result.get(result.size() - 1);
        checkEqualsCredit(familyCreditAccountEmpty, resultAccount);
        assertEquals(actualSize + 1, result.size());
    }
//
//    @Rollback
//    @Test
//    public void createNewCreditPersonal() {
//        BigInteger debitId = new BigInteger("2");
//        creditAccountDao.createPersonalCreditByDebitAccountId(debitId, (PersonalCreditAccount) personalCreditAccountEmpty);
//        List<PersonalCreditAccount> result = creditAccountDao.getAllPersonalCreditsByAccountId(debitId);
//        PersonalCreditAccount resultAccount = result.get(result.size() - 1);
//        checkEqualsCredit(personalCreditAccountEmpty, resultAccount);
//    }

    private void checkEqualsCredit(AbstractCreditAccount creditOne, AbstractCreditAccount creditTwo) {
        assertEquals(creditOne.getName(), creditTwo.getName());
        assertEquals(creditOne.getAmount(), creditTwo.getAmount());
        assertEquals(creditOne.getPaidAmount(), creditTwo.getPaidAmount());
        assertEquals(creditOne.getDate(), creditTwo.getDate());
        assertEquals(creditOne.getCreditRate(), creditTwo.getCreditRate());
        assertEquals(creditOne.getDateTo(), creditTwo.getDateTo());
        assertEquals(creditOne.getMonthDay(), creditTwo.getMonthDay());
        assertEquals(creditOne.isPaid(), creditTwo.isPaid());
        checkEqualsDebt(creditOne.getDebt(), creditTwo.getDebt());
    }

    private void checkEqualsDebt(Debt debtOne, Debt debtTwo) {
        assertEquals(debtOne.getDateFrom(), debtTwo.getDateFrom());
        assertEquals(debtOne.getDateTo(), debtTwo.getDateTo());
        assertEquals(debtOne.getAmountDebt(), debtTwo.getAmountDebt());
    }
}
