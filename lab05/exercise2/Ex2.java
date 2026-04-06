package exercise2;

import java.util.Scanner;

public class Ex2 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentManager manager = new StudentManager();

    public static void main(String[] args) {
        int option = 0;
        do {
            displayMenu();
            System.out.print("Choose an option: ");
            try {
                option = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } catch (java.util.InputMismatchException e) {
                scanner.nextLine(); // consume invalid input
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteMultipleStudents();
                    break;
                case 3:
                    displayTable();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (option != 4);
        scanner.close();
    }

    static void displayMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Add new students");
        System.out.println("2. Delete multiple students");
        System.out.println("3. Display students");
        System.out.println("4. Quit");
    }

    static void addStudent() {
        boolean addMore = true;
        while (addMore) {
            System.out.print("Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            manager.addStudent(new Student(id, name, age));

            System.out.print("Do you want to add more (y/n)?: ");
            String response = scanner.nextLine().trim().toLowerCase();
            addMore = response.equals("y");
        }
    }

    static void deleteMultipleStudents() {
        if (manager.isEmpty()) {
            System.out.println("No students to delete!");
            return;
        }

        displayTable();
        
        boolean deleteMore = true;
        while (deleteMore) {
            System.out.print("Input student ID: ");
            int idToDelete = scanner.nextInt();
            scanner.nextLine();

            boolean found = manager.deleteById(idToDelete);

            if (!found) {
                System.out.println("\u001B[33mStudent with ID " + idToDelete + " not found!\u001B[0m");
            } else {
                System.out.println("\u001B[33mStudent with ID " + idToDelete + " deleted\u001B[0m");
            }

            System.out.print("Do you want to delete more (y/n)?: ");
            String response = scanner.nextLine().trim().toLowerCase();
            deleteMore = response.equals("y");
        }
    }

    static void displayTable() {
        if (manager.isEmpty()) {
            System.out.println("No students in the table.");
            return;
        }

        System.out.println("\n" + "=".repeat(60));
        System.out.println(String.format("| %-3s | %-15s | %-3s |", "No", "ID", "Name", "Age"));
        System.out.println(String.format("| %-3s | %-15s | %-3s |", "", "ID", "Name", "Age"));
        System.out.println("=".repeat(60));
        
        for (int i = 0; i < manager.getStudents().size(); i++) {
            Student s = manager.getStudents().get(i);
            System.out.println(String.format("| %-3d | %-15d | %-15s | %-3d |", i + 1, s.getId(), s.getName(), s.getAge()));
        }
        System.out.println("=".repeat(60));
    }
}