import java.util.Scanner;

public class Ex4_StudentLists {
    static class Student {
        private int id;
        private String name;
        private int age;

        Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        void display(int rowNo, int noWidth, int idWidth, int nameWidth, int ageWidth) {
            System.out.print("|");
            System.out.printf("%-" + noWidth + "d|", rowNo);
            System.out.printf("%-" + idWidth + "d|", id);
            System.out.printf("%-" + nameWidth + "s|", name);
            System.out.printf("%-" + ageWidth + "d|", age);
            System.out.println();
        }
    }

    static void printFrame(int noWidth, int idWidth, int nameWidth, int ageWidth) {
        System.out.print("+");
        for (int i = 0; i < noWidth; i++) System.out.print("-");
        System.out.print("+");
        for (int i = 0; i < idWidth; i++) System.out.print("-");
        System.out.print("+");
        for (int i = 0; i < nameWidth; i++) System.out.print("-");
        System.out.print("+");
        for (int i = 0; i < ageWidth; i++) System.out.print("-");
        System.out.println("+");
    }

    static Student[] growArray(Student[] students) {
        Student[] bigger = new Student[students.length * 2];
        for (int i = 0; i < students.length; i++) {
            bigger[i] = students[i];
        }
        return bigger;
    }

    static void listStudents(Student[] students, int counter) {
        if (counter == 0) {
            System.out.println("No students added yet.");
            return;
        }

        int longestName = "Name".length();
        for (int i = 0; i < counter; i++) {
            longestName = Math.max(longestName, students[i].getName().length());
        }

        longestName += 2;
        int noWidth = 5;
        int idWidth = 6;
        int ageWidth = 6;

        printFrame(noWidth, idWidth, longestName, ageWidth);
        System.out.print("|");
        System.out.printf("%-" + noWidth + "s|", "No");
        System.out.printf("%-" + idWidth + "s|", "ID");
        System.out.printf("%-" + longestName + "s|", "Name");
        System.out.printf("%-" + ageWidth + "s|", "Age");
        System.out.println();
        printFrame(noWidth, idWidth, longestName, ageWidth);

        for (int i = 0; i < counter; i++) {
            students[i].display(i + 1, noWidth, idWidth, longestName, ageWidth);
            printFrame(noWidth, idWidth, longestName, ageWidth);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[10];
        int counter = 0;

        while (true) {
            System.out.println("Student #" + (counter + 1) + ":");

            System.out.print("Id: ");
            int id = sc.nextInt();

            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();

            if (counter == students.length) {
                students = growArray(students);
            }

            Student student = new Student(id, name, age);
            students[counter] = student;
            counter++;

            System.out.print("Do you want to add more (y/n)?: ");
            char choice = sc.next().charAt(0);

            if (choice == 'n' || choice == 'N') {
                break;
            }
        }

        listStudents(students, counter);

        sc.close();
    }
}
