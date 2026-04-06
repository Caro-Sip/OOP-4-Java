package exercise5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex5 {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final File TEACHER_FILE = new File("./lab05/exercise5/teacher.txt");
    private static final File STUDENT_FILE = new File("./lab05/exercise5/student.txt");
    private static final File SECURITY_GUARD_FILE = new File("./lab05/exercise5/securityguard.txt");

    public static void main(String[] args) {
        ensureFile(TEACHER_FILE);
        ensureFile(STUDENT_FILE);
        ensureFile(SECURITY_GUARD_FILE);

        while (true) {
            printMainMenu();
            int option = readInt("Choose an option: ");
            switch (option) {
                case 1:
                    viewAll();
                    break;
                case 2:
                    addNew();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    SCANNER.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("==== Menu ====");
        System.out.println("1. View all");
        System.out.println("2. Add new");
        System.out.println("3. Quit");
    }

    private static void addNew() {
        System.out.println("==== Add new resource ====");
        System.out.println("1. Teacher");
        System.out.println("2. Student");
        System.out.println("3. Security guard");
        int option = readInt("Choose an opt: ");

        switch (option) {
            case 1:
                addTeacher();
                break;
            case 2:
                addStudent();
                break;
            case 3:
                addSecurityGuard();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    private static void viewAll() {
        List<Teacher> teachers = loadTeachers();
        List<Student> students = loadStudents();
        List<SecurityGuard> guards = loadSecurityGuards();

        System.out.println("==== Teacher ====");
        if (teachers.isEmpty()) {
            System.out.println("No teachers found.");
        } else {
            for (int i = 0; i < teachers.size(); i++) {
                System.out.println((i + 1) + ". " + teachers.get(i).toDisplayString());
            }
        }

        System.out.println("\n==== Student ====");
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println((i + 1) + ". " + students.get(i).toDisplayString());
            }
        }

        System.out.println("\n==== Security guard ====");
        if (guards.isEmpty()) {
            System.out.println("No security guards found.");
        } else {
            for (int i = 0; i < guards.size(); i++) {
                System.out.println((i + 1) + ". " + guards.get(i).toDisplayString());
            }
        }
    }

    private static void addTeacher() {
        String firstName = readLine("First Name: ");
        String lastName = readLine("Last Name: ");
        String sex = readLine("Sex: ");
        String email = readLine("Email: ");
        String subjects = readLine("Subject: ");
        double salary = readDouble("Salary: ");

        Teacher teacher = new Teacher(firstName, lastName, sex, email, subjects, salary);
        appendLine(TEACHER_FILE, teacher.toStorageString());
    }

    private static void addStudent() {
        String firstName = readLine("First Name: ");
        String lastName = readLine("Last Name: ");
        String sex = readLine("Sex: ");
        String email = readLine("Email: ");
        int year = readInt("Year: ");
        String major = readLine("Major: ");

        Student student = new Student(firstName, lastName, sex, email, year, major);
        appendLine(STUDENT_FILE, student.toStorageString());
    }

    private static void addSecurityGuard() {
        String firstName = readLine("First Name: ");
        String lastName = readLine("Last Name: ");
        String sex = readLine("Sex: ");
        String email = readLine("Email: ");
        String role = readLine("Role: ");

        SecurityGuard guard = new SecurityGuard(firstName, lastName, sex, email, role);
        appendLine(SECURITY_GUARD_FILE, guard.toStorageString());
    }

    private static List<Teacher> loadTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(TEACHER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                Teacher teacher = Teacher.fromStorageString(line);
                if (teacher != null) {
                    teachers.add(teacher);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to read teacher file.");
        }
        return teachers;
    }

    private static List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(STUDENT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                Student student = Student.fromStorageString(line);
                if (student != null) {
                    students.add(student);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to read student file.");
        }
        return students;
    }

    private static List<SecurityGuard> loadSecurityGuards() {
        List<SecurityGuard> guards = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(SECURITY_GUARD_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                SecurityGuard guard = SecurityGuard.fromStorageString(line);
                if (guard != null) {
                    guards.add(guard);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to read security guard file.");
        }
        return guards;
    }

    private static void ensureFile(File file) {
        try {
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Failed to create file: " + file.getPath());
        }
    }

    private static void appendLine(File file, String line) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Failed to write file: " + file.getPath());
        }
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return SCANNER.nextLine().trim();
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(SCANNER.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = Double.parseDouble(SCANNER.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }
}
