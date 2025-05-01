import java.util.Scanner;

class FibonacciGenerator implements Runnable {
    private int limit;

    public FibonacciGenerator(int limit) {
        this.limit = limit;
    }

    @Override
    public void run() {
        System.out.println("Fibonacci Series:");
        if (limit <= 0) {
            System.out.println("Limit should be a positive integer.");
            return;
        }

        long a = 0, b = 1;
        System.out.print(a + " ");

        if (limit > 1) {
            System.out.print(b + " ");
        }

        for (int i = 2; i < limit; i++) {
            long nextFib = a + b;
            System.out.print(nextFib + " ");
            a = b;
            b = nextFib;
        }
        System.out.println("\nFibonacci thread finished.");
    }
}

class EvenNumberDisplayer implements Runnable {
    private int start;
    private int end;

    public EvenNumberDisplayer(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        System.out.println("\nEven Numbers in range [" + start + ", " + end + "]:");
        if (start > end) {
            System.out.println("Invalid range: Start should be less than or equal to End.");
            return;
        }

        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\nEven numbers thread finished.");
    }
}

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the limit for Fibonacci numbers: ");
        int fibLimit = scanner.nextInt();

        System.out.print("Enter the start of the range for even numbers: ");
        int evenStart = scanner.nextInt();
        System.out.print("Enter the end of the range for even numbers: ");
        int evenEnd = scanner.nextInt();

        FibonacciGenerator fibonacciTask = new FibonacciGenerator(fibLimit);
        EvenNumberDisplayer evenTask = new EvenNumberDisplayer(evenStart, evenEnd);

        Thread fibonacciThread = new Thread(fibonacciTask);
        Thread evenThread = new Thread(evenTask);

        fibonacciThread.start();
        evenThread.start();

        System.out.println("\nMain thread finished.");
        scanner.close();
    }
}
