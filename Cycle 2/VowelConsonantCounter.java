// 17. Count the number of vowels and consonants in a line of text

import java.util.Scanner;

public class VowelConsonantCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the line of text
        System.out.println("Enter a line of text:");
        String text = scanner.nextLine();

        // Initialize counters for vowels and consonants
        int vowelCount = 0, consonantCount = 0;

        // Convert text to lowercase for case-insensitive comparison
        text = text.toLowerCase();

        // Check each character in the text
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Check if the character is a vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            }
            // Check if the character is a consonant (a letter but not a vowel)
            else if (ch >= 'a' && ch <= 'z') {
                consonantCount++;
            }
        }

        // Display the counts
        System.out.println("Number of vowels: " + vowelCount);
        System.out.println("Number of consonants: " + consonantCount);

        scanner.close();
    }
}
