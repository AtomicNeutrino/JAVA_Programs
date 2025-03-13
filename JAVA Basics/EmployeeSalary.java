//5. write a program to display grades
/* A (90% and above) = "Excellent work!"
 B (80% to 89%) = "Good job!"
 C (70% to 79%) = "You can do better"
 D (60% to 69%) = "Work harder"
 F (Below 60%) = "Failed. Try again" */

import java.util.Scanner;

public class EmployeeSalary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input role
        System.out.print("Enter the role (Manager, Developer, Intern): ");
        String role = scanner.nextLine().trim();

        // Input years of experience
        System.out.print("Enter years of experience: ");
        double experience;
        try {
            experience = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("Please enter a valid number for years of experience.");
            scanner.close();
            return;
        }

        // Base salaries for roles
        double baseSalary;
        switch (role.toLowerCase()) {
            case "manager":
                baseSalary = 50000;
                break;
            case "developer":
                baseSalary = 30000;
                break;
            case "intern":
                baseSalary = 15000;
                break;
            default:
                System.out.println("Invalid role. Please choose Manager, Developer, or Intern.");
                scanner.close();
                return;
        }

        // Calculate bonus based on experience
        double bonus = 0;
        if (experience >= 3 && experience <= 5) {
            bonus = 0.10 * baseSalary; // 10% bonus
        } else if (experience > 5) {
            bonus = 0.20 * baseSalary; // 20% bonus
        } // No bonus for less than 3 years

        // Calculate total salary
        double totalSalary = baseSalary + bonus;

        // Display total salary
        System.out.printf("Total salary for a %s with %.1f years of experience is: %.2f%n", role, experience, totalSalary);

        scanner.close();
    }
}
