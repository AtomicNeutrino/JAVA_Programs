import java.util.Scanner;
class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}
public class Phone {
    public static void validatePhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
        // Remove any non-digit characters (spaces, hyphens, etc.)
        String digitsOnly = phoneNumber.replaceAll("[^\\d]", "");
        if (digitsOnly.length() != 10) {
            throw new InvalidPhoneNumberException("Phone number must have exactly 10 digits.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a phone number to validate: ");
        String phoneNumber = scanner.nextLine();
        try {
            validatePhoneNumber(phoneNumber);
            System.out.println("Phone number is valid.");
        } catch (InvalidPhoneNumberException e) {
            System.err.println("Phone number validation failed: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
