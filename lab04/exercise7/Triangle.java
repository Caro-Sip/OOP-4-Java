package lab04.exercise7;

public class Triangle extends Line {
    protected Point p3;

    public Triangle(Point p1, Point p2, Point p3) {
        super(p1, p2);
        this.p3 = p3;
    }
    
    private Point getP1() {
        return new Point(x, y);
    }
    
    private Point getP2() {
        return end;
    }

    public double getPerimeter() {
        Point p1 = getP1();
        Point p2 = getP2();
        double side1 = p1.distance(p2);
        double side2 = p2.distance(p3);
        double side3 = p3.distance(p1);
        return side1 + side2 + side3;
    }

    public double getArea() {
        Point p1 = getP1();
        Point p2 = getP2();
        double side1 = p1.distance(p2);
        double side2 = p2.distance(p3);
        double side3 = p3.distance(p1);
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public void display() {
        System.out.println("Triangle with vertices:");
        new Point(x, y).display();
        end.display();
        p3.display();
        System.out.println("Perimeter: " + getPerimeter());
        System.out.println("Area: " + getArea());
    }
}
