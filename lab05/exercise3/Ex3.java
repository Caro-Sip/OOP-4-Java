package lab05.exercise3;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex3 {
    private ArrayList<Point> lines = new ArrayList<>();
    private ArrayList<Rectangle> rectangles = new ArrayList<>();
    private ArrayList<Triangle> triangles = new ArrayList<>();

    public static void main(String[] args) {
        Ex3 manager = new Ex3();
        manager.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAllLines();
                    break;
                case 2:
                    viewAllRectangles();
                    break;
                case 3:
                    viewAllTriangles();
                    break;
                case 4:
                    addNewShape(scanner);
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        }
    }

    private void displayMenu() {
        System.out.println("==== Menu ====");
        System.out.println("1. View all lines");
        System.out.println("2. View all rectangles");
        System.out.println("3. View all triangles");
        System.out.println("4. Add a new shape");
        System.out.println("5. Quit");
        System.out.print("Choose an opt: ");
    }

    private void viewAllLines() {
        if (lines.isEmpty()) {
            System.out.println("No lines available.");
            return;
        }
        System.out.println("==== List all lines ====");
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + ". ");
            lines.get(i).display();
            System.out.println();
        }
    }

    private void viewAllRectangles() {
        if (rectangles.isEmpty()) {
            System.out.println("No rectangles available.");
            return;
        }
        System.out.println("==== List all rectangles ====");
        for (int i = 0; i < rectangles.size(); i++) {
            System.out.println((i + 1) + ". ");
            rectangles.get(i).display();
            System.out.println();
        }
    }

    private void viewAllTriangles() {
        if (triangles.isEmpty()) {
            System.out.println("No triangles available.");
            return;
        }
        System.out.println("==== List all triangles ====");
        for (int i = 0; i < triangles.size(); i++) {
            System.out.println((i + 1) + ". ");
            triangles.get(i).display();
            System.out.println();
        }
    }

    private void addNewShape(Scanner scanner) {
        System.out.println("\n==== Add new shape ====");
        System.out.println("Select a shape:");
        System.out.println("1. Line");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");
        System.out.print("Choose an opt: ");
        int shapeChoice = scanner.nextInt();

        switch (shapeChoice) {
            case 1:
                addLine(scanner);
                break;
            case 2:
                addRectangle(scanner);
                break;
            case 3:
                addTriangle(scanner);
                break;
            default:
                System.out.println("Invalid shape option.");
        }
    }

    private void addLine(Scanner scanner) {
        System.out.println("\n---- Add new shape ----");
        System.out.print("Input x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Input y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("Input x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Input y2: ");
        double y2 = scanner.nextDouble();

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        Line line = new Line(p1, p2);
        lines.add(line);
        System.out.println("Line added successfully!");
    }

    private void addRectangle(Scanner scanner) {
        System.out.println("\n---- Add new shape ----");
        System.out.print("Input x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Input y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("Input x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Input y2: ");
        double y2 = scanner.nextDouble();

        Point topLeft = new Point(x1, y1);
        Point bottomRight = new Point(x2, y2);
        Rectangle rectangle = new Rectangle(topLeft, bottomRight);
        rectangles.add(rectangle);
        System.out.println("Rectangle added successfully!");
    }

    private void addTriangle(Scanner scanner) {
        System.out.println("\n---- Add new shape ----");
        System.out.print("Input x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Input y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("Input x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Input y2: ");
        double y2 = scanner.nextDouble();
        System.out.print("Input x3: ");
        double x3 = scanner.nextDouble();
        System.out.print("Input y3: ");
        double y3 = scanner.nextDouble();

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        Point p3 = new Point(x3, y3);
        Triangle triangle = new Triangle(p1, p2, p3);
        triangles.add(triangle);
        System.out.println("Triangle added successfully!");
    }
}
