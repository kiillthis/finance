package com.netcracker.dao.impl;

import com.netcracker.AssertUtils;
import com.netcracker.configs.WebConfig;
import com.netcracker.dao.PersonalDebitAccountDao;
import com.netcracker.models.FamilyDebitAccount;
import com.netcracker.models.PersonalDebitAccount;
import com.netcracker.models.User;
import com.netcracker.models.enums.PersonalAccountStatusActive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfig.class)
public class PersonalDebitAccountDaoTests {

    @Autowired
    private PersonalDebitAccountDao personalDebitAccountDao;
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate template;
    private PersonalDebitAccount personalDebitAccount;
    private BigInteger id = BigInteger.valueOf(25);
    private static final double delta = 0.1;
    private static final String CREATE_USER = "INSERT ALL " +
            "INTO OBJECTS(OBJECT_ID,OBJECT_TYPE_ID,NAME) VALUES (objects_id_s.nextval, 1, ' ') "
            +
            "INTO ATTRIBUTES(ATTR_ID, OBJECT_ID, VALUE) VALUES(5, objects_id_s.currval, ?) "
            +
            "INTO ATTRIBUTES(ATTR_ID, OBJECT_ID, VALUE) VALUES(3, objects_id_s.currval, ?) "
            +
            "INTO ATTRIBUTES(ATTR_ID, OBJECT_ID, VALUE) VALUES(4, objects_id_s.currval, ?) "
            +
            "SELECT * " +
            "FROM DUAL";
    private static final String DELETE_USER = " DELETE FROM OBJECTS WHERE NAME = 'user_Tests' ";

    private static final String DELETE_ACC = " DELETE FROM OBJECTS WHERE NAME = 'Name1' ";

    @Before
    public void setUp() {
        Locale.setDefault(Locale.ENGLISH);
        template = new JdbcTemplate(dataSource);
    }

    @Test
    public void getPersonalAccountById() {
        PersonalDebitAccount personalDebitAccount = personalDebitAccountDao.getPersonalAccountById(id);
        String name = "PER_DEB_ACC2";
        double amount = 10000;
        assertEquals(id, personalDebitAccount.getId());
        assertEquals(name, personalDebitAccount.getObjectName());
        assertEquals(amount, personalDebitAccount.getAmount(), delta);

        String usname = "Dimas";
        String status = "YES";
        assertEquals(BigInteger.valueOf(24), personalDebitAccount.getOwner().getId());
        assertEquals(usname, personalDebitAccount.getOwner().getName());
        assertEquals("mailDimas@gmail.com", personalDebitAccount.getOwner().geteMail());
        assertEquals("passwordDima", personalDebitAccount.getOwner().getPassword());
        assertEquals(status, personalDebitAccount.getOwner().getUserStatusActive().toString());
    }

    @Test
    public void createPersonalAccount() {
        User owner = new User.Builder()
                .user_id(BigInteger.valueOf(AssertUtils.getCurrentSequenceId(template)))
                .user_name("Dimas")
                .user_eMail("mailDimas@gmail.com")
                .user_password("passwordDima")
                .build();
        template.update(CREATE_USER, new Object[]{
                owner.getName(),
                owner.geteMail(),
                owner.getPassword()
        });

        PersonalDebitAccount personalDebitAccount = new PersonalDebitAccount.Builder()
                .debitId(BigInteger.valueOf(AssertUtils.getCurrentSequenceId(template)))
                .debitObjectName("PER_DEB_ACC1")
                .debitAmount(Long.valueOf(1234L))
                .debitPersonalAccountStatus(PersonalAccountStatusActive.YES)
                .debitOwner(owner)
                .build();

        PersonalDebitAccount personalDebitAccount1 = personalDebitAccountDao.createPersonalAccount(personalDebitAccount);
        assertEquals("PER_DEB_ACC1", personalDebitAccount1.getObjectName());
        template.update(DELETE_USER);
        template.update(DELETE_ACC);
    }

    @Test
    public void deletePersonalAccountById() {
        personalDebitAccountDao.deletePersonalAccountById(BigInteger.valueOf(121), BigInteger.valueOf(43));
    }

    @Test
    public void deletePersonalAccountByUserId() {
        personalDebitAccountDao.deletePersonalAccountByUserId(BigInteger.valueOf(121), BigInteger.valueOf(43));
    }

    @Test
    public void updateAmount() {
        personalDebitAccountDao.updateAmountOfPersonalAccount(id, 5000L);
        double am = 5000;
        assertEquals(am, personalDebitAccountDao.getPersonalAccountById(id).getAmount(), delta);
        personalDebitAccountDao.updateAmountOfPersonalAccount(id, 10000L);
    }
    @Test
    public void getListFamilyAccounts() {
        ArrayList<PersonalDebitAccount> persAccounts = (ArrayList<PersonalDebitAccount>) personalDebitAccountDao.getAllPersonalAccounts();
        for (PersonalDebitAccount expected : persAccounts) {
            System.out.println(expected.getId() + " " + expected.getObjectName() + " " + expected.getAmount() + " " + expected.getStatus() + " "
                    + expected.getOwner().getName() + " " + expected.getOwner().geteMail());
        }
    }
}