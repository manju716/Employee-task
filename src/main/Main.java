package main;

import java.util.Scanner;

import Employee.Employee;
import dao.EmployeeDAO;

public class Main {
    public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Employee Database App ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();
                    System.out.print("Department: ");
                    String dept = sc.next();
                    dao.addEmployee(new Employee(0, name, salary, dept));
                    break;

                case 2:
                    dao.viewEmployees();
                    break;

                case 3:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("New Name: ");
                    String newName = sc.next();
                    System.out.print("New Salary: ");
                    double newSalary = sc.nextDouble();
                    dao.updateEmployee(id, newName, newSalary);
                    break;

                case 4:
                    System.out.print("ID: ");
                    int deleteId = sc.nextInt();
                    dao.deleteEmployee(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}

