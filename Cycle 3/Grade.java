import java.util.Scanner;
class InvalidGradeException extends Exception {
    public InvalidGradeException(String message) {
        super(message);
    }
}
public class Grade {
    public static void validateGrade(char grade) throws InvalidGradeException {
        if (grade < 'A' || grade > 'F') {
            throw new InvalidGradeException("Invalid grade: " + grade + ". Grade must be between 'A' and 'F'.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the student's grade (A-F): ");
        String input = scanner.nextLine().toUpperCase(); // Convert to uppercase for case-insensitivity
        if (input.length() == 1) {
            char grade = input.charAt(0);
            try {
                validateGrade(grade);
                System.out.println("Grade '" + grade + "' is valid.");
            } catch (InvalidGradeException e) {
                System.err.println("Grade validation failed: " + e.getMessage());
            }
        } else {
            System.err.println("Invalid input. Please enter a single letter grade (A-F).");
        }
        scanner.close();
    }
}