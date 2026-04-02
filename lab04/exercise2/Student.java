package lab04.exercise2;

public class Student {
    String id;
    String name;
    int age;

    public Student(){}

    public Student(String id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void displayTabular(int counter){
        System.out.printf("| %-5s | %-5s | %-20s | %-4d |%n", counter, id, name, age);
    }
}
