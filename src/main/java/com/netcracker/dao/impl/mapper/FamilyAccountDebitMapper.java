package com.netcracker.dao.impl.mapper;

import com.netcracker.models.FamilyDebitAccount;
import com.netcracker.models.User;
import com.netcracker.models.enums.FamilyAccountStatusActive;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FamilyAccountDebitMapper implements RowMapper<FamilyDebitAccount> {


    @Override
    public FamilyDebitAccount mapRow(ResultSet rs, int i) throws SQLException {

        UserDaoMapper userMapper = new UserDaoMapper();
        User user = userMapper.mapRow(rs, i);

        return new FamilyDebitAccount.Builder()
                .debitId(rs.getBigDecimal("DEBIT_ID").toBigInteger())
                .debitObjectName(rs.getString("NAME_DEBIT"))
                .debitAmount(Long.valueOf(rs.getString("AMOUNT_DEBIT")))
                .debitFamilyAccountStatus(FamilyAccountStatusActive.getStatusByKey(rs.getBigDecimal("STATUS_DEBIT").toBigInteger()))
                .debitOwner(user).build();
    }
}
