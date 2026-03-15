package Lab02;

public class Ex1_HelloMyName {
    public static void main(String[] args){
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Input your name: ");
        String name = scanner.nextLine();
        scanner.next();

        System.out.println("Hello "+ name +"!");

        scanner.close();
    }
}
