package com.example.__using_transaction_to_implement_money_transfer;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.math.BigDecimal;

@Repository
public class AccountRepository {

    private JdbcTemplate jdbc;

    AccountRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }
    public Account getAccount(int id){
        AccountMapper accountMapper = new AccountMapper();
        String sql = "SELECT * FROM account WHERE id = ?";
        return (Account)jdbc.queryForObject(sql,accountMapper,id);
    }
    public void changeAmount(BigDecimal amount,int id){
        String sql = "UPDATE account SET amount = ? WHERE id = ?";
        jdbc.update(sql,amount,id);
    }
    public List<Account> getAllRecords(){
        AccountMapper accountMapper = new AccountMapper();
        String sql = "SELECT * FROM account";
        return jdbc.query(sql,accountMapper);
    }
}
