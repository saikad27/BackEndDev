package com.example.__using_spring_data_jdbc_to_implement_data_persistence.dao;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.__using_spring_data_jdbc_to_implement_data_persistence.model.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends CrudRepository<Account,Long> {
    public List<Account> findAccountsByName(String name);

    @Query("SELECT * FROM account WHERE name = :name")
    public List<Account> findAccounts(String name);

    @Modifying
    @Query("UPDATE account SET amount = :amount WHERE id = :id")
    public void changeAmount(long id, BigDecimal amount);

}
