//3. write a program to find eligibility of a student :
/* a) Input marks for Math, Physics, and Chemistry.
b) Check eligibility based on:
Total marks of Math, Physics, and Chemistry.
1. Math >= 60 and physics >=50 and chemistry>=40 and total >=200
2. Total marks of Math and Physics >= 150 */

import java.util.Scanner;

public class StudentEligibility{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input marks for Math, Physics, and Chemistry
        System.out.print("Enter marks for Math: ");
        int math = scanner.nextInt();
        System.out.print("Enter marks for Physics: ");
        int physics = scanner.nextInt();
        System.out.print("Enter marks for Chemistry: ");
        int chemistry = scanner.nextInt();

        // Calculate total marks and total marks of Math and Physics
        int totalMarks = math + physics + chemistry;
        int totalMathPhysics = math + physics;

        // Check eligibility based on the conditions
        if ((math >= 60 && physics >= 50 && chemistry >= 40 && totalMarks >= 200) || (totalMathPhysics >= 150)) {
            System.out.println("The student is: Eligible");
        } else {
            System.out.println("The student is: Not Eligible");
        }

        scanner.close();
    }
}
