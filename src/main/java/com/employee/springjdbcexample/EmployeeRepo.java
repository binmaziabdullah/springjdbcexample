package com.employee.springjdbcexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*Here we are using RowMapper interface to get the employee list .
      this is the  anonymous way in which anonymous class instance passed in query method of JdbcTemplate
      which takes two argument i.e sql query and the rowMap instance.
    * RowMapper interface convert or map single row return from a query into a single Object and*/

    /*get All employee*/
    public List<Employee> getAllEmployee() {

        String query = "select * from employee";
        List<Employee> employeeList = jdbcTemplate.query(query, new MapRow());

        return employeeList;
    }

    /*get employee by specific id*/
    public Employee getEmployeeById(int id){

        String query = "select * from employee where id = ?";
        Employee employee = jdbcTemplate.queryForObject(query,new MapRow(), id);

        return employee;
    }

    /*Adding employees into a database*/
    public int insertEmployee(Employee employee) {

        String sql = "insert into employee(name,rollno) value(?,?)";
        int i = jdbcTemplate.update(sql, employee.getName(),
                employee.getRollno());
        return i;
    }

    /*Updating existing employee in a table*/
    public int updateEmployee(Employee employee) {

        String sql = "update employee set name = ?, rollno = ? where id = ?";
        int i = jdbcTemplate.update(sql, employee.getName(), employee.getRollno(), employee.getId());

        return i;
    }

    /*Delete employee by specific id*/
    public int deleteEmployee(int id) {

        String sql = "delete from employee where id = ?";

        return jdbcTemplate.update(sql, id);
    }


}
