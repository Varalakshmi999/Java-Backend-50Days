package com.employee;
import java.sql.*;

public class EmployeeDAO {
    public boolean addEmployee(Employee emp) {
        String sql = "INSERT INTO employees (name, email, salary) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());
            ps.setDouble(3, emp.getSalary());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Employee e1 = new Employee("Varalakshmi", "veluguladurgavaralakshmi@gmail.com", 50000);
        if(dao.addEmployee(e1)) {
            System.out.println("✅ Employee Inserted Successfully! Day 4 Rocking!");
        } else {
            System.out.println("❌ Failed!");
        }
    }
}