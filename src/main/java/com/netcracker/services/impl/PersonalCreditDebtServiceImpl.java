package com.netcracker.services.impl;

import com.netcracker.dao.CreditDeptDao;
import com.netcracker.services.PersonalCreditDebtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;

@Service
public class PersonalCreditDebtServiceImpl implements PersonalCreditDebtService {

    @Autowired
    CreditDeptDao creditDeptDao;

    @Override
    public void changeDebtDateTo(BigInteger id, Date date) {
        creditDeptDao.updateFamilyDebtDateTo(id, date);
    }

    @Override
    public void changeDebtDateFrom(BigInteger id, Date date) {
        creditDeptDao.updatePersonalDebtDateFrom(id, date);
    }

    @Override
    public void changeDebtAmount(BigInteger id, long amount) {
        creditDeptDao.updatePersonalDebtAmount(id, amount);
    }
}
