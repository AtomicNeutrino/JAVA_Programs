//10. Create a Rectangle class with:
/* ● Fields: length and width (both double).
● Constructors:
● Constructors:
o A default constructor setting length and width to 1.
o A parameterized constructor to initialize given values.
● Methods:
o calculateArea(): Returns area (length * width).
o calculatePerimeter(): Returns perimeter (2 * (length + width)).
Test:
 Create different rectangles and print their area and perimeter.
*/
import java.util.Scanner;

public class Rectangle {
    // Fields: length and width
    private double length;
    private double width;

    // Default constructor (sets length and width to 1)
    public Rectangle() {
        this.length = 1;
        this.width = 1;
    }

    // Parameterized constructor (sets given length and width)
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Method to calculate area
    public double calculateArea() {
        return length * width;
    }

    // Method to calculate perimeter
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    // Main method to test the Rectangle class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for length and width
        System.out.print("Enter the length of the rectangle: ");
        double length = scanner.nextDouble();

        System.out.print("Enter the width of the rectangle: ");
        double width = scanner.nextDouble();

        // Create a Rectangle object using user input
        Rectangle userRectangle = new Rectangle(length, width);

        // Display area and perimeter
        System.out.println("\nRectangle Details:");
        System.out.println("Length: " + length + ", Width: " + width);
        System.out.println("Area: " + userRectangle.calculateArea());
        System.out.println("Perimeter: " + userRectangle.calculatePerimeter());

        scanner.close();
    }
}
