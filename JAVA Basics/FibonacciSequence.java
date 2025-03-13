//8.Print the Fibonacci sequence up to a given limit.

import java.util.Scanner;

public class FibonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the limit for the Fibonacci sequence: ");
        int limit = scanner.nextInt();
        
        int a = 0, b = 1;
        System.out.print("Fibonacci Sequence: " + a + " " + b + " ");
        
        int nextTerm = a + b;
        while (nextTerm <= limit) {
            System.out.print(nextTerm + " ");
            a = b;
            b = nextTerm;
            nextTerm = a + b;
        }
        
        scanner.close();
    }
}
