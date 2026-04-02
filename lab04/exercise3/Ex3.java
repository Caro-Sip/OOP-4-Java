package lab04.exercise3;

import java.util.Scanner;

public class Ex3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookManager manager = new BookManager(100);

        int choice;
        do {
            System.out.println("\n==== Menu ===");
            System.out.println("1. View all books");
            System.out.println("2. Add a new book");
            System.out.println("3. Update a book");
            System.out.println("4. Quit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    manager.viewAll();
                    break;
                case 2:
                    System.out.print("Input ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Input Title: ");
                    String title = sc.nextLine();
                    System.out.print("Input Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Input Author: ");
                    String author = sc.nextLine();
                    manager.addBook(isbn, title, price, author);
                    break;
                case 3:
                    System.out.println("==== Update a book ====");
                    System.out.print("Input ISBN: ");
                    String updateIsbn = sc.nextLine();
                    manager.updateBook(updateIsbn, sc);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (choice != 4);

        sc.close();
    }
}