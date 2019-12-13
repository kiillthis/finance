package com.netcracker.services;

import com.netcracker.models.User;

import javax.mail.MessagingException;
import javax.swing.plaf.basic.BasicButtonUI;
import java.math.BigInteger;
import java.nio.file.LinkOption;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;


public interface EmailServiceSender {

    public void sendMailBeforeDeactivate(String emailTo, String userName, BigInteger userId);

    public void sendMailAboutPersonalDebt(String emailTo, String userName, String perName, Long amount, BigInteger userId);

    public void sendMailAboutFamilyDebt(String emailTo, String userName,String famName, Long amount, BigInteger userId);

    public void sendText(String emailTo, BigInteger userId) throws MessagingException;

    public void sendMailReminderPersonalCredit(String emailTo, String userName, Long amountPaid, String credName,BigInteger userId, LocalDate date);

    public void sendMailReminderFamilyCredit(String emailTo, String userName, Long amountPaid, String credName,BigInteger userId, LocalDate date);

    public void sendMailReminderPersonalExpense(User user, BigInteger id, BigInteger userId, Date date);

    public void sendMailAutoPersonalIncome(User user, BigInteger id, BigInteger userId, Date date);

    public void sendMailReminderFamilyExpense(User user, BigInteger id, BigInteger userId, Date date);

    public void sendMailAutoFamilyIncome(User user, BigInteger id, BigInteger userId, Date date);



}