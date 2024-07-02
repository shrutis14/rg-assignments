package org.example;

import java.sql.*;

public class EmployeeDAO {

    private Connection conn;

    // JDBC URL, username, and password of MySQL server
    private String url = "jdbc:mysql://localhost:3306/jdbc";
    private String user = "";
    private String password = "";

    public EmployeeDAO() throws SQLException {
        conn = DriverManager.getConnection(url, user, password);
    }

    // Method to create a new employee record
    public void createEmployee(Employee emp) throws SQLException {
        String sql = "INSERT INTO employees (name, department) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, emp.getName());
        stmt.setString(2, emp.getDepartment());
        stmt.executeUpdate();
        stmt.close();
        System.out.println("Employee created successfully.");
    }

    // Method to read an employee record by ID
    public Employee readEmployee(int id) throws SQLException {
        Employee emp = null;
        String sql = "SELECT * FROM employees WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setDepartment(rs.getString("department"));
        }
        rs.close();
        stmt.close();
        return emp;
    }

    // Method to update an employee record
    public void updateEmployee(Employee emp) throws SQLException {
        String sql = "UPDATE employees SET name = ?, department = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, emp.getName());
        stmt.setString(2, emp.getDepartment());
        stmt.setInt(3, emp.getId());
        int rowsUpdated = stmt.executeUpdate();
        stmt.close();
        if (rowsUpdated > 0) {
            System.out.print("Employee updated successfully:");
            System.out.println("Employee: " + emp.getName()+"-"+"Department: "+emp.getDepartment());
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Method to delete an employee record
    public void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        int rowsDeleted = stmt.executeUpdate();
        stmt.close();
        if (rowsDeleted > 0) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Close the connection
    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    public static void main(String[] args) {
        try {
            EmployeeDAO dao = new EmployeeDAO();

            // Create a new employee
            Employee newEmployee = new Employee();
            newEmployee.setName("A");
            newEmployee.setDepartment("CSE");
            dao.createEmployee(newEmployee);
            newEmployee.setName("B");
            newEmployee.setDepartment("IT");
            dao.createEmployee(newEmployee);

            // Read an employee by ID
            Employee retrievedEmployee = dao.readEmployee(8);
            if (retrievedEmployee != null) {
                System.out.println("Retrieved Employee: " + retrievedEmployee.getName() +
                        " - Department: " + retrievedEmployee.getDepartment());
            }

            // Update an employee
            if (retrievedEmployee != null) {
                retrievedEmployee.setDepartment("IT");
                dao.updateEmployee(retrievedEmployee);
            }

            // Delete an employee
            dao.deleteEmployee(9);

            dao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class Employee {
    private int id;
    private String name;
    private String department;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
