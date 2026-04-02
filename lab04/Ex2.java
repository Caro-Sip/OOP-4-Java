package lab04;

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

    public void displayTabular(int counter){
        System.out.printf("| %-5s | %-5s | %-20s | %-4d |%n", counter++, id, name, age);
    }
}

public class Ex2 {
    static int counter = 0;

    static void printMenu(){
        System.out.println("==== Menu ====");
        System.out.println("1. View all students");
        System.out.println("2. Add a new student");
        System.out.println("3. Delete a student");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Student students[] = new Student[100];

        printMenu();
        System.out.print("Choose an option: ");
        int input = sc.nextInt();
        System.out.println();

        switch(input){
            case 1:
                System.out.println();
                System.out.print("===============================================\n");
                System.out.printf("| %-5s | %-5s | %-20s | %-4s |%n", "No", "ID", "Name", "Age");
                System.out.print("===============================================\n");
                for (Student s : students){
                    System.out.printf("| %-5s | %-5s | %-20s | %-4d |%n", counter++, s.id, s.name, s.age);
                }
                System.out.print("===============================================\n");
                break;
            case 2:
                System.out.println("Student #" + (counter + 1) + ":");
            
                System.out.print("Id: ");
                String id = sc.nextLine();
        
                System.out.print("Name: ");
                String name = sc.nextLine();
        
                System.out.print("Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                Student tStudent = new Student(id, name, age);

                students[counter] = tStudent;
                counter++;
            case 3:
                System.out.println("WIP");
            case 4:
                System.exit(0);
        }

        sc.close();
    }
}
