package lab04.exercise7;

public class ProgrammingStudent extends ITStudent {
    private double programmingScore;

    public ProgrammingStudent(String id, String name, int semester, double itScore, double programmingScore) {
        super(id, name, semester, itScore);
        this.programmingScore = programmingScore;
    }

    public double getProgrammingScore() {
        return programmingScore;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Programming Score: " + programmingScore);
    }
}