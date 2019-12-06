package com.netcracker.services;

import java.math.BigInteger;
import java.util.Date;

public interface FamilyCreditDebtService {

    void changeDebtDateTo(BigInteger id, Date date);

    void changeDebtDateFrom(BigInteger id, Date date);

    void changeDebtAmount(BigInteger id, long amount);
}
