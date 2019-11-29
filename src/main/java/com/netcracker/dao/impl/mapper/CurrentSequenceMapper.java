package com.netcracker.dao.impl.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrentSequenceMapper implements RowMapper<Integer> {

    @Override
    public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getInt("last_number");
    }
}
