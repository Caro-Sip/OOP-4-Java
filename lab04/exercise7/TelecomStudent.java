package lab04.exercise7;

public class TelecomStudent extends ITStudent {
    private double telecomScore;

    public TelecomStudent(String id, String name, int semester, double itScore, double telecomScore) {
        super(id, name, semester, itScore);
        this.telecomScore = telecomScore;
    }

    public double getTelecomScore() {
        return telecomScore;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Telecom Score: " + telecomScore);
    }
}