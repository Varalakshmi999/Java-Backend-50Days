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
                list.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDouble("salary")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

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
        } catch (Exception e) { e.printStackTrace(); }
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

    // --- DAY 7 NEW METHOD ---
    public boolean deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();

        // 1. Create a temp employee to delete
        System.out.println("--- Adding Temp Employee for Delete Test ---");
        Employee temp = new Employee("TestDelete", "delete@test.com", 10000);
        dao.addEmployee(temp);

        // Find its ID (last added)
        java.util.List<Employee> all = dao.getAllEmployees();
        int lastId = all.get(all.size() - 1).getId();
        System.out.println("Created ID: " + lastId);

        // 2. Show all before delete
        System.out.println("\n--- Before Delete ---");
        for (Employee e : dao.getAllEmployees()) System.out.println(e);

        // 3. Delete
        if (dao.deleteEmployee(lastId)) {
            System.out.println("\n✅ Deleted ID " + lastId + " Successfully!");
        }

        // 4. Show all after delete
        System.out.println("\n--- After Delete ---");
        for (Employee e : dao.getAllEmployees()) System.out.println(e);

        System.out.println("\n✅ Day 7 - Full CRUD Success! JDBC Part Completed!");
    }
}