package com.example.connectionlifecycle.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;
    public EmployeeDao(DataSource dataSource){
        jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }
    public int countEmployee(){
        return jdbcTemplate.queryForObject("select count(id) from employee",
                Integer.class);
    }
}
