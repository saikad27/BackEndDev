package com.example.__using_transaction_to_implement_money_transfer;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account obj = new Account();
        obj.setId(rs.getInt("id"));
        obj.setName(rs.getString("name"));
        obj.setAmount(rs.getBigDecimal("amount"));
        return obj;
    }
}
