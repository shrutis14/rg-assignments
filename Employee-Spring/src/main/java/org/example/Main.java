package org.example;

import org.example.config.DatabaseConfig;
import org.example.model.Employee;
import org.example.service.EmployeeService;
import org.example.service.EmployeeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize Spring Application Context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);

        // Get EmployeeService Bean
        EmployeeService employeeService =context.getBean(EmployeeService.class);

        // Create a new employee
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("A");
        employee.setDepartment("HR");
        employeeService.save(employee);
        System.out.println("Employee saved: " + employee);
        System.out.println("Employee with id: " + employee.getId());
        employee.setId(2);
        employee.setName("B");
        employee.setDepartment("Tech");
        employeeService.save(employee);
        System.out.println("Employee saved: " + employee);
        System.out.println("Employee with id: " + employee.getId());
        // Update the employee
        employee.setName("Shruti S");
        employee.setDepartment("IT Support");
        employeeService.update(employee);
        System.out.println("Employee updated: " + employee);

        // Get employee by ID
        Employee empById = employeeService.getById(employee.getId());
        System.out.println("Employee by ID: " + empById);

        // Get all employees
        List<Employee> allEmployees = employeeService.getAll();
        System.out.println("All employees:");
        for (Employee emp : allEmployees) {
            System.out.println(emp);
        }

//        Delete an employee
         employeeService.delete(employee.getId());
         System.out.println("Employee deleted with id " + employee.getId());

        // Close the application context
        context.close();
    }
}
