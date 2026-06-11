package Ex1;

public class Task {
    int duration;
    String name;

    public Task(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() { return name; }
    public int getDuration() { return duration; }

    public void setName(String name) { this.name = name; }
    public void setDuration(int duration) { this.duration = duration; }
}
