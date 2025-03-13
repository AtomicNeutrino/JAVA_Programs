// 19. .search for a pattern in a string and replace it with another string.


import java.util.Scanner;

public class PatternReplacement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the original string: ");
        String originalString = scanner.nextLine();

        System.out.print("Enter the pattern to search for: ");
        String pattern = scanner.nextLine();

        System.out.print("Enter the replacement string: ");
        String replacement = scanner.nextLine();

        // Replace all occurrences of the pattern with the replacement string
        String modifiedString = originalString.replaceAll(pattern, replacement);

        System.out.println("Modified string: " + modifiedString);

        scanner.close();
    }
}
