package exercise2;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean deleteById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return students.isEmpty();
    }

    public List<Student> getStudents() {
        return students;
    }
}
