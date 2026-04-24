package Ex8;


class Author {
    String authorId;
    String authorName;
    String country;
    
    public Author() {}
    
    public Author(String authorId, String authorName, String country) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.country = country;
    }
}

class Book {
    String bookId;
    String title;
    double price;
    int pages;
    Author author;
    
    public Book() {}
    
    public Book(String bookId, String title, double price, int pages, Author author) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.pages = pages;
        this.author = author;
    }
    
    public void setValues(String bookId, String title, double price, int pages, Author author) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.pages = pages;
        this.author = author;
    }
    
    public void display() {
        System.out.printf("ID: %s | Title: %-25s | Price: $%.2f | Pages: %d | Author: %s (%s)%n", 
            bookId, title, price, pages, author.authorName, author.country);
    }
}

public class Ex8d_BookStore {
    public static void main(String[] args) {
        Author author1 = new Author("A001", "George Orwell", "United Kingdom");
        Author author2 = new Author("A002", "J.K. Rowling", "United Kingdom");

        Book book1 = new Book();
        book1.setValues("B001", "1984", 15.99, 328, author1);
        
        Book book2 = new Book();
        book2.setValues("B002", "Animal Farm", 12.99, 141, author1);
        
        Book book3 = new Book();
        book3.setValues("B003", "Harry Potter", 18.99, 309, author2);

        Book[] books = new Book[3];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;

        System.out.println("\n=== Book Store Catalog ===");
        for (Book book : books) {
            book.display();
        }
    }
}
