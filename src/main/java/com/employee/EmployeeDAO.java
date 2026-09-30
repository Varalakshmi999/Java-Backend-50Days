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

    public java.util.List<Employee> getAllEmployees() {
        java.util.List<Employee> list = new java.util.ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Employee e = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDouble("salary")
                );
                list.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        System.out.println("--- All Employees from DB ---");
        for (Employee e : dao.getAllEmployees()) {
            System.out.println(e);
        }
        System.out.println("✅ Day 5 - Fetch Success!");
    }
}