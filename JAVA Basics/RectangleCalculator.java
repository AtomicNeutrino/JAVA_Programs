//Write a program to find the area and perimeter of a rectangle.

import java.util.Scanner;

public class RectangleCalculator{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the length of the rectangle: ");
        double length = scanner.nextDouble();
        
        System.out.print("Enter the width of the rectangle: ");
        double width = scanner.nextDouble();
        
        double area = length * width;
        double perimeter = 2 * (length + width);
        
        System.out.println("Area of the rectangle: " + area);
        System.out.println("Perimeter of the rectangle: " + perimeter);
        
        scanner.close();
    }
}
