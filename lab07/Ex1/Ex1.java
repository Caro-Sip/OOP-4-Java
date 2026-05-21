package Ex1;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args){
        // Default sample outputs
        System.out.println("==== Sample Shape Area Calculations ====");
        GeometryArea geometryArea = new GeometryArea();
        
        System.out.println("Rectangle (width=5, height=10): " + geometryArea.calculateRectableArea(5, 10));
        System.out.println("Circle (radius=5): " + geometryArea.calculateCircleArea(5));
        System.out.println("Triangle (sides=3,4,5): " + geometryArea.calculateTriangleArea(3, 4, 5));
        System.out.println("Triangle (base=10, height=8): " + geometryArea.calculateTriangleArea(10, 8));
        System.out.println("Semi-circle (radius=5): " + geometryArea.calculateSemiCircleArea(5));
        System.out.println("Sector (radius=5, angle=90): " + geometryArea.calculateSectorArea(5, 90));
        
        System.out.println("\n==== Shape Area Calculation ====");      
        System.out.println("1. Rectangle");
        System.out.println("2. Circle");
        System.out.println("3. Triangle (three sides)");
        System.out.println("4. Triangle (base and height)");
        System.out.println("5. Semi circle");
        System.out.println("6. Sector");
        System.out.println("7. Quit");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option: ");
        int option = scanner.nextInt();

        double area;

        switch (option) {
            case 1:
                System.out.print("Enter width: ");
                double width = scanner.nextDouble();
                System.out.print("Enter height: ");
                double height = scanner.nextDouble();
                area = geometryArea.calculateRectableArea(width, height);
                System.out.println("Rectangle area: " + area);
                break;
            case 2:
                System.out.print("Enter radius: ");
                double radius = scanner.nextDouble();
                area = geometryArea.calculateCircleArea(radius);
                System.out.println("Circle area: " + area);
                break;
            case 3:
                System.out.print("Enter side a: ");
                double a = scanner.nextDouble();
                System.out.print("Enter side b: ");
                double b = scanner.nextDouble();
                System.out.print("Enter side c: ");
                double c = scanner.nextDouble();
                area = geometryArea.calculateTriangleArea(a, b, c);
                System.out.println("Triangle area: " + area);
                break;
            case 4:
                System.out.print("Enter base: ");
                double base = scanner.nextDouble();
                System.out.print("Enter height: ");
                double triHeight = scanner.nextDouble();
                area = geometryArea.calculateTriangleArea(base, triHeight);
                System.out.println("Triangle area: " + area);
                break;
            case 5:
                System.out.print("Enter radius: ");
                double semiRadius = scanner.nextDouble();
                area = geometryArea.calculateSemiCircleArea(semiRadius);
                System.out.println("Semi-circle area: " + area);
                break;
            case 6:
                System.out.print("Enter radius: ");
                double sectorRadius = scanner.nextDouble();
                System.out.print("Enter angle (degrees): ");
                double angle = scanner.nextDouble();
                area = geometryArea.calculateSectorArea(sectorRadius, angle);
                System.out.println("Sector area: " + area);
                break;
            case 7:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid option.");
        }

        scanner.close();
    }
}
