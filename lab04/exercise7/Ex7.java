package lab04.exercise7;

public class Ex7 {
    public static void main(String[] args) {
        System.out.println("===== Multiple Inheritance (Composition) =====\n");

        // Multiple Inheritance Pattern
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 0);
        Point p3 = new Point(3, 4);

        Line line = new Line(p1, p2);
        line.display();

        System.out.println("\n");

        Triangle triangle = new Triangle(p1, p2, p3);
        triangle.display();

        System.out.println("\n");

        Rectangle rectangle = new Rectangle(p1, p3);
        rectangle.display();

        System.out.println("\n===== Hierarchical Inheritance =====\n");

        // Hierarchical Inheritance Pattern
        ProgrammingStudent progStudent = new ProgrammingStudent("001", "Makara", 2, 90.0, 85.5);
        progStudent.display();

        System.out.println("\n");

        TelecomStudent telecomStudent = new TelecomStudent("002", "Kompheak", 3, 92.0, 88.0);
        telecomStudent.display();

        System.out.println("\n");

        ITStudent itStudent = new ITStudent("003", "Vandana", 1, 92.0);
        itStudent.display();
    }
}