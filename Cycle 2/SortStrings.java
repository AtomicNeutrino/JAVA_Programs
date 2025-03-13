// 16. Sort an array of strings.

import java.util.Arrays;
import java.util.Scanner;

public class SortStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of strings
        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        // Input the strings into an array
        String[] strings = new String[n];
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }

        // Sort the array of strings
        Arrays.sort(strings);

        // Display the sorted array
        System.out.println("\nSorted strings:");
        for (String str : strings) {
            System.out.println(str);
        }

        scanner.close();
    }
}
