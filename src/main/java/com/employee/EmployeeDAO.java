package com.employee;
import java.sql.*;

public class EmployeeDAO {


    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDouble("salary")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateEmployee(Employee emp) {
        String sql = "UPDATE employees SET name=?, email=?, salary=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());
            ps.setDouble(3, emp.getSalary());
            ps.setInt(4, emp.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();

        // 1. Fetch single employee
        System.out.println("--- Fetch ID 1 ---");
        Employee e = dao.getEmployeeById(1);
        System.out.println(e);

        // 2. Update salary
        if (e != null) {
            e.setSalary(75000);
            if (dao.updateEmployee(e)) {
                System.out.println("✅ Updated Successfully!");
                System.out.println("After Update: " + dao.getEmployeeById(1));
            }
        }
        System.out.println("✅ Day 6 - GetById & Update Success!");
    }
}