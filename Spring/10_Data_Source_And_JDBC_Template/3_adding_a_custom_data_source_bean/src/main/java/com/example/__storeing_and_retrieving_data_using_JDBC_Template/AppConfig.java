package com.example.__storeing_and_retrieving_data_using_JDBC_Template;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Value("${custom.datasource.url}")
    private String url;

    @Value("${custom.datasource.username}")
    private String username;

    @Value("${custom.datasource.password}")
    private String password;

    @Bean
    public DataSource hikariCP(){
        HikariDataSource datasource = new HikariDataSource();
        datasource.setJdbcUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setConnectionTimeout(1000);

        return datasource;
    }
}
