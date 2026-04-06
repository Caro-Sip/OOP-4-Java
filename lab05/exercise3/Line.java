package exercise3;

public class Line extends Point {
    protected Point end;

    public Line(Point start, Point end) {
        super(start.x, start.y);
        this.end = end;
    }

    public double getLength() {
        return distance(end);
    }

    public void display() {
        System.out.println("Line from ");
        super.display();
        System.out.println("to ");
        end.display();
        System.out.println("Length: " + getLength());
    }
}
