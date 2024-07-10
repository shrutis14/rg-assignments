package org.example.dao;
import org.example.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
public interface EmployeeDAO {
    void save(Employee employee);
    void update(Employee employee);
    void delete(int id);
    Employee getById(int id);
    List<Employee> getAll();
}

