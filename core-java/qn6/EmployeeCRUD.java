import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeCRUD {
    private List<Employee> employees;

    public EmployeeCRUD() {
        employees = new ArrayList<>();
    }

    // Create a new employee
    public void createEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added: " + employee);
    }

    // Read an employee by ID
    public Employee readEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    // Update an existing employee
    public boolean updateEmployee(Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getId() == updatedEmployee.getId()) {
                employees.set(i, updatedEmployee);
                System.out.println("Employee updated: " + updatedEmployee);
                return true;
            }
        }
        return false;
    }

    // Delete an employee by ID
    public boolean deleteEmployee(int id) {
        Optional<Employee> employeeToDelete = employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();

        if (employeeToDelete.isPresent()) {
            employees.remove(employeeToDelete.get());
            System.out.println("Employee deleted: " + employeeToDelete.get());
            return true;
        } else {
            return false;
        }
    }
}

