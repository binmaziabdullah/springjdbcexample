package com.employee.springjdbcexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class MapRow implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setRollno(rs.getInt("rollno"));

        return employee;
    }


}
