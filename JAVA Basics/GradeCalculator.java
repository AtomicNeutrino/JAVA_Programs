// 5. write a program to display grades
/*A (90% and above) = "Excellent work!"
 B (80% to 89%) = "Good job!"
 C (70% to 79%) = "You can do better"
 D (60% to 69%) = "Work harder"
 F (Below 60%) = "Failed. Try again"
 */

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input score from the user
        System.out.print("Enter the score (0-100): ");
        try {
            double score = scanner.nextDouble();
            
            if (score >= 0 && score <= 100) {
                // Determine grade and message
                String grade;
                String message;

                if (score >= 90) {
                    grade = "A";
                    message = "Excellent work!";
                } else if (score >= 80) {
                    grade = "B";
                    message = "Good job!";
                } else if (score >= 70) {
                    grade = "C";
                    message = "You can do better";
                } else if (score >= 60) {
                    grade = "D";
                    message = "Work harder";
                } else {
                    grade = "F";
                    message = "Failed. Try again";
                }

                // Display grade and message
                System.out.println("Grade: " + grade + " - " + message);
            } else {
                System.out.println("Please enter a score between 0 and 100.");
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid numeric score.");
        } finally {
            scanner.close();
        }
    }
}
