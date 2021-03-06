package com.netcracker.services;

import com.netcracker.models.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public interface FamilyDebitService {
    FamilyDebitAccount createFamilyDebitAccount(FamilyDebitAccount familyDebitAccount);

    FamilyDebitAccount getFamilyDebitAccount(BigInteger debitId);

    void deleteFamilyDebitAccount(BigInteger debitId, BigInteger userId);

    boolean addUserToAccount(BigInteger accountId, BigInteger userId);

    void deleteUserFromAccount(BigInteger accountId, BigInteger userId);

    List<AbstractAccountOperation> getHistory(BigInteger familyAccountId, LocalDateTime date);

    Collection<User> getParticipantsOfFamilyAccount(BigInteger accountId);

    boolean isUserParticipant(BigInteger userId);

    Collection<FamilyDebitAccount> getAllFamilyAccounts();

    void updateAmountOfFamilyAccount(BigInteger accountId, double amount);

    List<ChartItem> getMonthData(BigInteger accountId);

    Collection<DonutChartItem> getMonthExpenseList(BigInteger accountId);

    Collection<DonutChartItem> getMonthIncomeList(BigInteger accountId);
}