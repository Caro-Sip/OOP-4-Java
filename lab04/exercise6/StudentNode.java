package lab04.exercise6;

public class StudentNode {
    private Student data;
    private StudentNode next;

    public StudentNode(Student data) {
        this.data = data;
        this.next = null;
    }

    public Student getData() {
        return data;
    }

    public StudentNode getNext() {
        return next;
    }

    public void setNext(StudentNode next) {
        this.next = next;
    }
}
