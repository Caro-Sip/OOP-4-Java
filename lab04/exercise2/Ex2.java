package lab04.exercise2;

import java.util.Scanner;

public class Ex2 {
    static int counter = 0;

    static int deleteById(Student[] students, int size, String targetId){
        int index = -1;
        for (int i = 0; i < size; i++){
            if (students[i] != null && students[i].id.equals(targetId)){
                index = i;
                break;
            }
        }

        if (index == -1){
            System.out.println("Student not found.");
            return size;
        }

        // Display before deleting
        System.out.println("Student to be deleted:");
        System.out.print("===============================================\n");
        System.out.printf("| %-5s | %-5s | %-20s | %-4s |%n", "No", "ID", "Name", "Age");
        System.out.print("===============================================\n");
        students[index].displayTabular(index + 1);
        System.out.print("===============================================\n");

        // Delete by shifting left
        for (int i = index; i < size - 1; i++){
            students[i] = students[i + 1];
        }
        students[size - 1] = null;

        return size - 1;
    }

    static void printMenu(){
        System.out.println("==== Menu ====");
        System.out.println("1. View all students");
        System.out.println("2. Add a new student");
        System.out.println("3. Delete a student");
        System.out.println("4. Exit");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Student students[] = new Student[100];
        boolean running = true;

        while(running) {
            printMenu();
            System.out.print("Choose an option: ");
            int input = sc.nextInt();
            sc.nextLine(); // consume newline after nextInt
            System.out.println();

            switch(input){
                case 1:
                    System.out.println();
                    System.out.print("===============================================\n");
                    System.out.printf("| %-5s | %-5s | %-20s | %-4s |%n", "No", "ID", "Name", "Age");
                    System.out.print("===============================================\n");
                    for (int i = 0; i < counter; i++){
                        students[i].displayTabular(i + 1);
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
                    break;
                case 3:
                    System.out.println("==== Delete a student ====");
                    System.out.print("Input student ID: ");
                    String tempId = sc.nextLine();

                    int newSize = deleteById(students, counter, tempId);
                    if(newSize != counter) {
                        counter = newSize;
                        System.out.println("Deleted successfully.");
                    }
                    break;
                case 4:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        }

        sc.close();
    }
}
