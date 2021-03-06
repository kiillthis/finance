package com.netcracker.dao.impl;

import com.netcracker.configs.WebConfig;
import com.netcracker.dao.CreditDeptDao;
import com.netcracker.models.Debt;
import com.netcracker.services.utils.DateUtils;
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

import static org.junit.Assert.assertEquals;

@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CreditDeptDaoTest {

    private Debt personalDebtOne;
    private Debt familyDebtOne;
    private Debt emptyDebt;
    private int month;

    @Autowired
    private CreditDeptDao creditDeptDao;

    @Before
    public void initializeObjects() {
        personalDebtOne = new Debt.Builder()
                .debtId(new BigInteger("14"))
                .amountDebt(0L)
                .dateFrom(LocalDate.of(2019, 11, 30))
                .dateTo(LocalDate.of(2020, 2, 28))
                .build();

        emptyDebt = new Debt.Builder()
                .debtId(new BigInteger("14"))
                .amountDebt(0L)
                .build();

        familyDebtOne = new Debt.Builder()
                .amountDebt(0L)
                .dateFrom(LocalDate.of(2019, 11, 30))
                .dateTo(LocalDate.of(2020, 2, 28))
                .debtId(new BigInteger("15"))
                .build();
    }

    @Rollback
    @Test
    public void updatePersonalDebtDateFromTest() {
        BigInteger accId = personalDebtOne.getDebtId();
        LocalDate newDate = LocalDate.of(2019, 11, 30);

        creditDeptDao.updatePersonalDebtDateFrom(accId, DateUtils.localDateToDate(newDate.atTime(0,0)));

    }

    @Rollback
    @Test
    public void updateFamilyDebtDateFromTest() {
        BigInteger accId = familyDebtOne.getDebtId();
        LocalDate newDate = LocalDate.of(2019, 11, 21);

        creditDeptDao.updateFamilyDebtDateFrom(accId, DateUtils.localDateToDate(newDate.atTime(0,0)));

    }

    @Rollback
    @Test
    public void updatePersonalDebtDateToTest() {
        BigInteger accId = personalDebtOne.getDebtId();
        LocalDate newDate = LocalDate.of(2019, 11, 30);

        creditDeptDao.updatePersonalDebtDateTo(accId, DateUtils.localDateToDate(newDate.atTime(0,0)));

    }

    @Rollback
    @Test
    public void updateFamilyDebtDateToTest() {
        BigInteger accId = familyDebtOne.getDebtId();
        LocalDate newDate = LocalDate.of(2019, 11, 30);

        creditDeptDao.updateFamilyDebtDateTo(accId, DateUtils.localDateToDate(newDate.atTime(0,0)));

    }

    @Rollback
    @Test
    public void updatePersonalDebtAmountTest() {
        BigInteger accId = personalDebtOne.getDebtId();
        double newAmount = personalDebtOne.getAmountDebt();

        creditDeptDao.updatePersonalDebtAmount(accId, newAmount);

    }

    @Rollback
    @Test
    public void updateFamilyDebtAmountTest() {
        BigInteger accId = familyDebtOne.getDebtId();
        double newAmount = familyDebtOne.getAmountDebt();

        creditDeptDao.updateFamilyDebtAmount(accId, newAmount);


    }

    @Rollback
    @Test
    public void updateToEmptyPersonalDebt() {
        BigInteger accId = personalDebtOne.getDebtId();

        creditDeptDao.updatePersonalDebtAmount(accId, 0L);
        creditDeptDao.updatePersonalDebtDateFrom(accId, null);
        creditDeptDao.updatePersonalDebtDateTo(accId, null);

    }

    @Rollback
    @Test
    public void updateToEmptyFamilyDebt() {
        BigInteger accId = personalDebtOne.getDebtId();

        creditDeptDao.updateFamilyDebtAmount(accId, 0L);
        creditDeptDao.updateFamilyDebtDateFrom(accId, null);
        creditDeptDao.updateFamilyDebtDateTo(accId, null);

    }

    private void checkEqualsDebt(Debt debtOne, Debt debtTwo) {
        assertEquals(debtOne.getDebtId(), debtTwo.getDebtId());
        assertEquals(debtOne.getDateFrom(), debtTwo.getDateFrom());
        assertEquals(debtOne.getDateTo(), debtTwo.getDateTo());
        assertEquals(debtOne.getAmountDebt(), debtTwo.getAmountDebt(), 2);
    }
}
