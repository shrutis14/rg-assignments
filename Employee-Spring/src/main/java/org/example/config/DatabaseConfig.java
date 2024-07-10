package org.example.config;

import org.example.dao.EmployeeDAO;
import org.example.dao.EmployeeDAOImpl;
import org.example.service.EmployeeService;
import org.example.service.EmployeeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/jdbc");
        dataSource.setUsername("");
        dataSource.setPassword("");
        return dataSource;
    }
    @Bean
    public EmployeeDAO employeeDAO() {
        return new EmployeeDAOImpl(dataSource());
    }
    @Bean
    public EmployeeService employeeService() {
        return new EmployeeServiceImpl(employeeDAO());
    }
}

