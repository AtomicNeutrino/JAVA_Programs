
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
public class Password {
    public static void validatePassword(String password) throws InvalidPasswordException {
        if (password.length() < 8) {
            throw new InvalidPasswordException("Password must be at least 8 characters long.");
        }
        Pattern digitPattern = Pattern.compile("\\d");
        Matcher digitMatcher = digitPattern.matcher(password);
        if (!digitMatcher.find()) {
            throw new InvalidPasswordException("Password must contain at least one number.");
        }
        Pattern specialCharPattern = Pattern.compile("[\\{$#&}]");
        Matcher specialCharMatcher = specialCharPattern.matcher(password);
        if (!specialCharMatcher.find()) {
            throw new InvalidPasswordException("Password must contain at least one special character from {$#&}.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password to validate: ");
        String password = scanner.nextLine();

        try {
            validatePassword(password);
            System.out.println("Password is valid.");
        } catch (InvalidPasswordException e) {
            System.err.println("Password validation failed: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}