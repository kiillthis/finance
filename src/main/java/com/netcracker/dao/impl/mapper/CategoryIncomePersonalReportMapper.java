package com.netcracker.dao.impl.mapper;

import com.netcracker.models.AbstractCategoryReport;
import com.netcracker.models.CategoryIncomeReport;
import com.netcracker.models.enums.CategoryIncome;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryIncomePersonalReportMapper implements RowMapper<CategoryIncomeReport> {

    @Override
    public CategoryIncomeReport mapRow(ResultSet resultSet, int i) throws SQLException {
        AbstractCategoryReport categoryIncomeReport =
                new CategoryIncomeReport.Builder()
                        .amount(Long.valueOf(resultSet.getString("amount")))
                        .categoryIncome(CategoryIncome.getNameByKey(resultSet.getBigDecimal("category").toBigInteger()))
                        .build();
        return (CategoryIncomeReport) categoryIncomeReport;
    }

}