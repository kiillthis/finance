package com.netcracker.services;

import com.netcracker.models.CreditOperation;
import com.netcracker.models.PersonalCreditAccount;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

public interface PersonalCreditService {

    void createPersonalCredit(BigInteger id, PersonalCreditAccount creditAccount);

    void deletePersonalCredit(BigInteger id);

    void addPersonalCreditPayment(BigInteger idAccount, BigInteger idCredit, long amount);

    void addPersonalCreditPaymentAuto(BigInteger idAccount, BigInteger idCredit, long amount);

    Collection<PersonalCreditAccount> getPersonalCredits(BigInteger id);

    Collection<CreditOperation> getAllPersonalCreditOperations(BigInteger id);

    PersonalCreditAccount getPersonalCreditAcount(BigInteger id);

    long getMonthPaymentAmount(PersonalCreditAccount creditAccount);
}
