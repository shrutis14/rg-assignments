public class Main {
    public static void main(String[] args) {
        EmployeeCRUD employeeCRUD = new EmployeeCRUD();

        Employee emp1 = new Employee(1, "A", "Engineering");
        Employee emp2 = new Employee(2, "B", "Marketing");
        Employee emp3 = new Employee(3, "C", "Sales");

        // Create employees
        employeeCRUD.createEmployee(emp1);
        employeeCRUD.createEmployee(emp2);
        employeeCRUD.createEmployee(emp3);

        // Read an employee
        System.out.println("\nRead Employee with ID 2:");
        System.out.println(employeeCRUD.readEmployee(2));

        // Update an employee
        Employee updatedEmp2 = new Employee(2, "B", "Product Management");
        employeeCRUD.updateEmployee(updatedEmp2);

        // Delete an employee
        employeeCRUD.deleteEmployee(3);
    }
}
