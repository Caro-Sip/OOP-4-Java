package lab04.exercise6;

public class Ex6 {
    public static void main(String[] args) {
        StudentList myArr = new StudentList();

        System.out.println("==> Add");
        myArr.add(new Student(1, "Makara", "Male", 20, "makara@email.com"));
        myArr.add(new Student(2, "Kompheak", "Female", 21, "kompheak@email.com"));
        myArr.display();

        System.out.println("\n==> Remove at last");
        myArr.add(new Student(3, "Minea", "Female", 22, "minea@email.com"));
        myArr.add(new Student(4, "Mehsa", "Female", 23, "mehsa@email.com"));
        myArr.removeLast();
        myArr.display();

        System.out.println("\n==> Remove at larger index");
        myArr.remove(10);

        System.out.println("\n==> Clear all element");
        myArr.clear();
        myArr.display();
    }
}
