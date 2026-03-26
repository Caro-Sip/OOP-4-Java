package lab03;
import java.util.Scanner;

public class Ex7_StudentManagement {

    public static void printMenu() {
        System.out.println("====== Menu ======");
        System.out.println("1. Create a student");
        System.out.println("2. List students");
        System.out.println("3. Quit");
    }

    public static void addStudent(Scanner scanner, Student students[], int counter){
        System.out.printf("Student #%d%n", counter + 1);
        System.out.printf("Id: ");
        int id = scanner.nextInt();

        System.out.printf("Name: ");
        scanner.nextLine(); 
        String name = scanner.nextLine(); 
        
        System.out.printf("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        Student tStudent = new Student();
        tStudent.setValue(id, name, age);
        students[counter] = tStudent;
        System.out.println("A student is added to the list");
    }

    public static void listStudents(Student students[], int counter) {
        if(counter == 0) {
            System.out.println("No students added yet.");
            return;
        }
        
        int longestName = "Name".length();
        
        // Find longest name
        for(int i = 0; i < counter; i++) {
            longestName = Math.max(longestName, students[i].getName().length());
        }
        
        longestName += 2;
        int noWidth = 5;
        int idWidth = 6;
        int ageWidth = 6;
        
        // Print table
        printFrame(noWidth, idWidth, longestName, ageWidth);
        System.out.print("|");
        System.out.printf("%-" + noWidth + "s|", "No");
        System.out.printf("%-" + idWidth + "s|", "ID");
        System.out.printf("%-" + longestName + "s|", "Name");
        System.out.printf("%-" + ageWidth + "s|", "Age");
        System.out.println();
        printFrame(noWidth, idWidth, longestName, ageWidth);
        
        for(int i = 0; i < counter; i++) {
            students[i].display(i + 1, noWidth, idWidth, longestName, ageWidth);
            printFrame(noWidth, idWidth, longestName, ageWidth);
        }
    }
    
    static void printFrame(int noWidth, int idWidth, int nameLen, int ageLen) {
        System.out.print("+");
        for(int i = 0; i < noWidth; i++) System.out.print("-");
        System.out.print("+");
        for(int i = 0; i < idWidth; i++) System.out.print("-");
        System.out.print("+");
        for(int i = 0; i < nameLen; i++) System.out.print("-");
        System.out.print("+");
        for(int i = 0; i < ageLen; i++) System.out.print("-");
        System.out.println("+");
    }

    public static void main(String[] args) {
        Student students[] = new Student[100];
        Scanner scanner = new Scanner(System.in);
        int counter = 0;

        while (true) {
            printMenu();
            System.out.print("Choose an option: ");
            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    if(counter < students.length) {
                        addStudent(scanner, students, counter);
                        counter++;
                    } 
                    else {
                        System.out.println("Array ch'aet bay cha hx!");
                    }
                    break;
                case 2:
                    listStudents(students, counter);
                    break;
                case 3:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
            System.out.println();
        }

    }

}

class Student {
    private int id;
    private String name;
    private int age;

    public Student(){
    
    }

    void setValue(int id, String name, int age) {
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
    
    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
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