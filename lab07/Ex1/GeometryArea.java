package Ex1;

public class GeometryArea extends ShapeArea {
    @Override
    public double calculateRectableArea(double width, double height) {
        return width * height;
    }

    @Override
    public double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculateTriangleArea(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double calculateTriangleArea(double base, double height) {
        return (base * height) / 2;
    }

    @Override
    public double calculateSemiCircleArea(double radius) {
        return (Math.PI * radius * radius) / 2;
    }

    @Override
    public double calculateSectorArea(double radius, double angle) {
        return (angle / 360) * Math.PI * radius * radius;
    }
}
