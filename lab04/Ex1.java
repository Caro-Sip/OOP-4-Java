package lab04;

import java.util.ArrayList;
import java.util.Scanner;

class Student{
    String id;
    String name;
    int age;

    public Student(){}

    public Student(String id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

public class Ex1 {
    static int counter = 0;
    static Scanner scanner = new Scanner(System.in);

    static void main(String[] args){
        char input;
        ArrayList<Student> students = new ArrayList<>();

        do{
            System.out.println("Student #" + (counter + 1) + ":");
            
            System.out.print("Id: ");
            String id = scanner.nextLine();
    
            System.out.print("Name: ");
            String name = scanner.nextLine();
    
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            Student tStudent = new Student(id, name, age);

            students.add(tStudent);

            System.out.print("Do you want to continue? (Y/n)");
            input = scanner.next().charAt(0);
            scanner.nextLine();
            counter++;
        } while(input == 'y' || input == 'Y');

        scanner.close();

        counter = 1;

        System.out.println();
        System.out.print("===============================================\n");
        System.out.printf("| %-5s | %-5s | %-20s | %-4s |%n", "No", "ID", "Name", "Age");
        System.out.print("===============================================\n");
        for (Student s : students){
            System.out.printf("| %-5s | %-5s | %-20s | %-4d |%n", counter++, s.id, s.name, s.age);
        }
        System.out.print("===============================================\n");
    }
}
