package exercise3;

public class Rectangle extends Triangle {
    protected Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        super(topLeft, bottomRight, new Point(topLeft.x, bottomRight.y));
        this.bottomRight = bottomRight;
    }

    public double getWidth() {
        return Math.abs(bottomRight.x - x);
    }

    public double getHeight() {
        return Math.abs(bottomRight.y - y);
    }

    public double getArea() {
        return getWidth() * getHeight();
    }

    public double getPerimeter() {
        return 2 * (getWidth() + getHeight());
    }

    public void display() {
        System.out.println("Rectangle:");
        System.out.println("Width: " + getWidth());
        System.out.println("Height: " + getHeight());
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
}
