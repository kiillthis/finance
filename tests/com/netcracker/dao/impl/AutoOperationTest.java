package com.netcracker.dao.impl;

import com.netcracker.AssertUtils;
import com.netcracker.configs.WebConfig;
import com.netcracker.dao.AutoOperationDao;
import com.netcracker.models.AbstractAutoOperation;
import com.netcracker.models.AutoOperationExpense;
import com.netcracker.models.AutoOperationIncome;
import com.netcracker.models.enums.CategoryExpense;
import com.netcracker.models.enums.CategoryIncome;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfig.class)
@Transactional
public class AutoOperationTest {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private AutoOperationDao autoOperationDao;

    private int dayOfMonth = 1;

    private AutoOperationIncome autoOperationIncomePersonalExpected;
    private AutoOperationExpense autoOperationExpensePersonalExpected;
    private AutoOperationIncome autoOperationIncomeFamilyExpected;
    private AutoOperationExpense autoOperationExpenseFamilyExpected;

    private String dateTodayString = "2019-12-16";
    private LocalDate dateToday = LocalDate.parse(dateTodayString);
    private String GET_COUNT_OF_AO_OBJECTS = "SELECT COUNT(*) FROM OBJECTS WHERE OBJECT_ID = 96";

    private BigInteger familyIncomeObjectIdAO = BigInteger.valueOf(96);
    private BigInteger familyExpenseObjectIdAO = BigInteger.valueOf(94);
    private BigInteger personalIncomeObjectIdAO = BigInteger.valueOf(95);
    private BigInteger personalExpenseObjectIdAO = BigInteger.valueOf(93);

    private BigInteger userId = BigInteger.valueOf(74);
    private BigInteger currentId;
    private BigInteger familyDebitId = BigInteger.valueOf(76);
    private BigInteger personalDebitId = BigInteger.valueOf(75);

    public AutoOperationTest() {

    }

    @Before
    public void setUp() {
        Locale.setDefault(Locale.ENGLISH);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Before
    public void initializeObjects() {
        autoOperationIncomePersonalExpected = new AutoOperationIncome.Builder().accountId(personalIncomeObjectIdAO)
                .dayOfMonth(dayOfMonth).accountAmount(13000.00).categoryIncome(CategoryIncome.AWARD).accountDebitId(personalDebitId)
                .accountDate(LocalDate.parse("2019-12-20").atTime(0,0)).build();

        autoOperationExpensePersonalExpected = new AutoOperationExpense.Builder().accountId(personalExpenseObjectIdAO)
                .dayOfMonth(dayOfMonth).accountAmount(17000.00).categoryExpense(CategoryExpense.FOOD).accountDebitId(personalDebitId)
                .accountDate(LocalDate.parse("2019-12-02").atTime(0,0)).build();

        autoOperationIncomeFamilyExpected = new AutoOperationIncome.Builder().accountId(familyIncomeObjectIdAO)
                .dayOfMonth(dayOfMonth).accountAmount(12000.00).categoryIncome(CategoryIncome.AWARD).accountDebitId(familyDebitId)
                .accountDate(LocalDate.parse("2019-12-15").atTime(0,0)).build();

        autoOperationExpenseFamilyExpected = new AutoOperationExpense.Builder().accountId(familyExpenseObjectIdAO)
                .dayOfMonth(dayOfMonth).accountAmount(16000.00).categoryExpense(CategoryExpense.FOOD).accountDebitId(familyDebitId)
                .accountDate(LocalDate.parse("2019-12-03").atTime(0,0)).build();
    }

    @Test
    public void getFamilyIncomeAutoOperation() {
        AutoOperationIncome autoOperationIncomeFamilyActual = autoOperationDao.getFamilyIncomeAutoOperation(familyIncomeObjectIdAO);
        AssertUtils.assertAutoOperationIncome(autoOperationIncomeFamilyExpected, autoOperationIncomeFamilyActual);
    }

    @Test
    public void getFamilyExpenseAutoOperation() {
        AutoOperationExpense autoOperationExpenseFamilyActual = autoOperationDao.getFamilyExpenseAutoOperation(familyExpenseObjectIdAO);
        AssertUtils.assertAutoOperationExpense(autoOperationExpenseFamilyExpected, autoOperationExpenseFamilyActual);
    }

    @Test
    public void getPersonalIncomeAutoOperation() {
        AutoOperationIncome autoOperationIncomePersonalActual = autoOperationDao.getPersonalIncomeAutoOperation(personalIncomeObjectIdAO);
        AssertUtils.assertAutoOperationIncome(autoOperationIncomePersonalExpected, autoOperationIncomePersonalActual);
    }

    @Test
    public void getPersonalExpenseAutoOperation() {
        AutoOperationExpense autoOperationExpensePersonalActual = autoOperationDao.getPersonalExpenseAutoOperation(personalExpenseObjectIdAO);
        AssertUtils.assertAutoOperationExpense(autoOperationExpensePersonalExpected, autoOperationExpensePersonalActual);
    }

    /*@Rollback
    @Test
    public void createFamilyIncomeAutoOperation() {
        AutoOperationIncome autoOperationIncomeFamilyActual = autoOperationDao.createFamilyIncomeAutoOperation(autoOperationIncomeFamilyExpected, userId, familyDebitId);
        currentId = autoOperationIncomeFamilyActual.getId();
        setDateAndId(autoOperationIncomeFamilyExpected, currentId, dateToday);
        AssertUtils.assertAutoOperationIncome(autoOperationIncomeFamilyExpected, autoOperationIncomeFamilyActual);
    }

    @Rollback
    @Test
    public void createFamilyExpenseAutoOperation() {
        AutoOperationExpense autoOperationExpenseFamilyActual = autoOperationDao.createFamilyExpenseAutoOperation(autoOperationExpenseFamilyExpected, userId, familyDebitId);
        currentId = autoOperationExpenseFamilyActual.getId();
        setDateAndId(autoOperationExpenseFamilyExpected, currentId, dateToday);
        AssertUtils.assertAutoOperationExpense(autoOperationExpenseFamilyExpected, autoOperationExpenseFamilyActual);
    }

    private void setDateAndId(AbstractAutoOperation autoOperation, BigInteger newId, LocalDate newDate) {
        autoOperation.setId(newId);
        autoOperation.setDate(newDate);
    }

    @Rollback
    @Test
    public void createPersonalIncomeAutoOperation() {
        AutoOperationIncome autoOperationIncomePersonalActual = autoOperationDao.createPersonalIncomeAutoOperation(autoOperationIncomePersonalExpected, personalDebitId);
        currentId = autoOperationIncomePersonalActual.getId();
        setDateAndId(autoOperationIncomePersonalExpected, currentId, dateToday);
        AssertUtils.assertAutoOperationIncome(autoOperationIncomePersonalExpected, autoOperationIncomePersonalActual);
    }

    @Rollback
    @Test
    public void createPersonalExpenseAutoOperation() {
        AutoOperationExpense autoOperationExpensePersonalActual = autoOperationDao.createPersonalExpenseAutoOperation(autoOperationExpensePersonalExpected, personalDebitId);
        currentId = autoOperationExpensePersonalActual.getId();
        setDateAndId(autoOperationExpensePersonalExpected, currentId, dateToday);
        AssertUtils.assertAutoOperationExpense(autoOperationExpensePersonalExpected, autoOperationExpensePersonalActual);
    }*/

    @Rollback
    @Test
    public void deleteAutoOperation() {
        int totalCount = 0;
        autoOperationDao.deleteAutoOperation(familyIncomeObjectIdAO);
        int countObjects = jdbcTemplate.queryForObject(GET_COUNT_OF_AO_OBJECTS, Integer.class);
        assertEquals(totalCount, countObjects);
    }
}
