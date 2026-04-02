package lab04.exercise7;

public class ITStudent {
    protected String id;
    protected String name;
    protected int semester;
    protected double itScore;

    public ITStudent(String id, String name, int semester, double itScore) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.itScore = itScore;
    }

    public double getITScore() {
        return itScore;
    }
    
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public int getSemester() {
        return semester;
    }

    public void display() {
        System.out.println("IT Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Semester: " + semester);
        System.out.println("IT Score: " + itScore);
    }
}