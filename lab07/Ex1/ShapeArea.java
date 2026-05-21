package Ex1;

public abstract class ShapeArea {
    abstract double calculateRectableArea(double width, double height);
    abstract double calculateCircleArea(double radius);
    abstract double calculateTriangleArea(double a, double b, double c);
    abstract double calculateTriangleArea(double base, double height);
    abstract double calculateSemiCircleArea(double radius);
    abstract double calculateSectorArea(double radius, double angle);
}
