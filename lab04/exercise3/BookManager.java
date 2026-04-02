package lab04.exercise3;

import java.util.Scanner;

public class BookManager {
    private Book[] books;
    private int count;

    public BookManager(int size) {
        books = new Book[size];
        count = 0;
    }

    public void addBook(String isbn, String title, double price, String author) {
        if (count < books.length) {
            books[count++] = new Book(isbn, title, price, author);
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Bookstore is full!");
        }
    }

    public void viewAll() {
        if (count == 0) {
            System.out.println("No books found.");
            return;
        }
        System.out.println("=================================================================");
        System.out.println(String.format("| %-6s | %-25s | %-7s | %-15s |", 
            "ISBN", "Title", "Price", "Author"));
        System.out.println("=================================================================");
        
        for (int i = 0; i < count; i++) {
            books[i].display();
        }
        System.out.println("=================================================================");
    }

    public void updateBook(String isbn, Scanner sc) {
        int index = findBookByIsbn(isbn);
        if (index == -1) {
            System.out.println("Book is not found. Try again");
            return;
        }

        Book book = books[index];
        System.out.println("Please update the following:");
        
        System.out.print("ISBN: ");
        String newIsbn = sc.nextLine();
        book.setIsbn(newIsbn);

        System.out.print("Title: ");
        String newTitle = sc.nextLine();
        book.setTitle(newTitle);

        System.out.print("Price: ");
        double newPrice = sc.nextDouble();
        book.setPrice(newPrice);
        sc.nextLine();

        System.out.print("Author: ");
        String newAuthor = sc.nextLine();
        book.setAuthor(newAuthor);

        System.out.println("Book updated successfully!");
    }

    private int findBookByIsbn(String isbn) {
        for (int i = 0; i < count; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                return i;
            }
        }
        return -1;
    }
}
