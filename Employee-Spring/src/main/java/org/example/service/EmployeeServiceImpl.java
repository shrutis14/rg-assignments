package org.example.service;

import org.example.dao.EmployeeDAO;
import org.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeDAO.update(employee);
    }

    @Override
    public void delete(int id) {
        employeeDAO.delete(id);
    }

    @Override
    public Employee getById(int id) {
        return employeeDAO.getById(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }
}

