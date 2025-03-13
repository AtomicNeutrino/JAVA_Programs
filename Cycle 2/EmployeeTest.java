// 12. Create an abstract class Employee with attributes name and id, and an abstract method
//       calculateSalary().
/* Create two subclasses:
   ● FullTimeEmployee (has monthlySalary).
   ● PartTimeEmployee (has hourlyRate and hoursWorked).
   Implement and test the system. */


import java.util.Scanner;

// Abstract class Employee
abstract class Employee {
    protected String name;
    protected int id;

    // Constructor to initialize name and id
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Abstract method to calculate salary
    public abstract double calculateSalary();

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
    }
}

// FullTimeEmployee subclass
class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

// PartTimeEmployee subclass
class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

// Main class
public class EmployeeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int numberOfEmployees = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Employee[] employees = new Employee[numberOfEmployees];

        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1) + ":");
            System.out.print("Enter Employee ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Employee Type (full-time/part-time): ");
            String type = scanner.nextLine().toLowerCase();

            if (type.equals("full-time")) {
                System.out.print("Enter Monthly Salary: ");
                double monthlySalary = scanner.nextDouble();
                employees[i] = new FullTimeEmployee(name, id, monthlySalary);
            } else if (type.equals("part-time")) {
                System.out.print("Enter Hourly Rate: ");
                double hourlyRate = scanner.nextDouble();
                System.out.print("Enter Hours Worked: ");
                int hoursWorked = scanner.nextInt();
                employees[i] = new PartTimeEmployee(name, id, hourlyRate, hoursWorked);
            }

            scanner.nextLine(); // Consume newline after number input
        }

        System.out.println("\nEmployee Details and Salaries:");
        for (Employee employee : employees) {
            employee.displayDetails();
            System.out.println("Salary: " + employee.calculateSalary());
            System.out.println(); // Blank line between employees
        }

        scanner.close();
    }
}
