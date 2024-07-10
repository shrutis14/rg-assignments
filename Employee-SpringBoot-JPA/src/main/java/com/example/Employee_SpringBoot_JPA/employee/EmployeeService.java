package com.example.Employee_SpringBoot_JPA.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+(this.employeeRepository));
    }
    public List<Employee> getEmployees() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+(this.employeeRepository));
        return this.employeeRepository.findAll();
    }
    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).orElse(null);
    }
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        System.out.println("Employee deleted successfully");

    }
}
