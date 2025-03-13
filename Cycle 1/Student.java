// 11. Create a Student class with:

/* ● Fields: studentId (int), name (String), marks (double)
   ● A constructor to initialize all fields.
   ● Methods:
   o displayDetails(): Displays student details.
   o isPassed(): Returns true if marks are 40 or above, else false.
   Test:
   Create multiple students and check their pass status */


import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    // Fields
    private int studentId;
    private String name;
    private double marks;

    // Constructor to initialize all fields
    public Student(int studentId, String name, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
    }

    // Method to check pass status
    public boolean isPassed() {
        return marks >= 40;
    }

    // Main method to test the Student class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add students");
            System.out.println("2. Display all student's details");
            System.out.println("3. Display a specific student's details");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add multiple students
                    System.out.print("Enter the number of students to add: ");
                    int numberOfStudents = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    for (int i = 0; i < numberOfStudents; i++) {
                        addStudent(scanner, students);
                    }
                    break;
                case 2:
                    // Display details and pass status for each student
                    System.out.println("\nStudent Details and Pass Status:");
                    for (Student student : students) {
                        student.displayDetails();
                        System.out.println("Pass Status: " + (student.isPassed() ? "Passed" : "Failed"));
                        System.out.println(); // Add space between student details
                    }
                    break;
                case 3:
                    // Display details for a specific student
                    System.out.print("Enter Student ID to display details: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    boolean found = false;
                    for (Student student : students) {
                        if (student.studentId == id) {
                            student.displayDetails();
                            System.out.println("Pass Status: " + (student.isPassed() ? "Passed" : "Failed"));
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    // Exit
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // Method to add a student
    private static void addStudent(Scanner scanner, ArrayList<Student> students) {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        // Create a new Student object and add it to the list
        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }
}

