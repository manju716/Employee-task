package dao;

import java.sql.*;

import Employee.Employee;
import dbconnection.DBConnection;

public class EmployeeDAO {

    public void addEmployee(Employee emp) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO employees(name, salary, department) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, emp.name);
            ps.setDouble(2, emp.salary);
            ps.setString(3, emp.department);
            ps.executeUpdate();
            System.out.println("Employee Added!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewEmployees() {
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM employees";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getDouble("salary") + " | " +
                        rs.getString("department")
                );
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateEmployee(int id, String name, double salary) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "UPDATE employees SET name=?, salary=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.println("Employee Updated!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deleteEmployee(int id) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "DELETE FROM employees WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Employee Deleted!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

