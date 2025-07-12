package com.example.__storeing_and_retrieving_data_using_JDBC_Template.dao;

import com.example.__storeing_and_retrieving_data_using_JDBC_Template.model.Purchase;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseRepository {
    private final JdbcTemplate jdbcTemplate;
    public PurchaseRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void storePurchase(Purchase purchase){
        String sql = "INSERT INTO purchase (product,price) VALUES(?,?)";
        jdbcTemplate.update(sql,purchase.getProduct(),purchase.getPrice());
    }
    public List<Purchase> findAllPurchases(){
        String sql = "SELECT * FROM purchase";
        RowMapper<Purchase> rowMapper = (r,i)->{
            Purchase purchase = new Purchase();
            purchase.setId(r.getInt("id"));
            purchase.setProduct(r.getString("product"));
            purchase.setPrice(r.getBigDecimal("price"));
            return purchase;
        };
        return jdbcTemplate.query(sql,rowMapper);
    }
}
