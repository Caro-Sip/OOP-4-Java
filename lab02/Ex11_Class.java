package lab02;

class IDCard {
    String cardId;
    String name;
    String dateOfBirth;
    String address;
    String expiryDate;
}

class FacebookPost {
    int postId;
    String author;
    String content;
    int likes;
    String timestamp;
}

class Phone {
    String phoneModel;
    String brand;
    double price;
    int storage;
    String color;
}

class Book {
    int bookId;
    String title;
    String author;
    double price;
    int pages;
}

public class Ex11_Class {
    public static void main(String[] args) {
        // ID Card objects
        IDCard card1 = new IDCard();
        card1.cardId = "ID001";
        card1.name = "Alice Johnson";
        card1.dateOfBirth = "1990-05-15";
        card1.address = "123 Main St";
        card1.expiryDate = "2030-05-15";
        
        IDCard card2 = new IDCard();
        card2.cardId = "ID002";
        card2.name = "Bob Smith";
        card2.dateOfBirth = "1985-08-20";
        card2.address = "456 Oak Ave";
        card2.expiryDate = "2028-08-20";
        
        IDCard card3 = new IDCard();
        card3.cardId = "ID003";
        card3.name = "Carol Davis";
        card3.dateOfBirth = "1992-12-10";
        card3.address = "789 Pine Rd";
        card3.expiryDate = "2032-12-10";
        
        IDCard[] cardArr = new IDCard[3];
        cardArr[0] = card1;
        cardArr[1] = card2;
        cardArr[2] = card3;
        
        // Facebook Post objects
        FacebookPost post1 = new FacebookPost();
        post1.postId = 1001;
        post1.author = "Alice Johnson";
        post1.content = "Beautiful sunset today!";
        post1.likes = 245;
        post1.timestamp = "2024-03-20 18:30:00";
        
        FacebookPost post2 = new FacebookPost();
        post2.postId = 1002;
        post2.author = "Bob Smith";
        post2.content = "Just finished a great book!";
        post2.likes = 156;
        post2.timestamp = "2024-03-21 10:15:00";
        
        FacebookPost post3 = new FacebookPost();
        post3.postId = 1003;
        post3.author = "Carol Davis";
        post3.content = "Coffee and coding at my favorite cafe";
        post3.likes = 189;
        post3.timestamp = "2024-03-21 14:45:00";
        
        FacebookPost[] postArr = new FacebookPost[3];
        postArr[0] = post1;
        postArr[1] = post2;
        postArr[2] = post3;
        
        // Phone objects
        Phone phone1 = new Phone();
        phone1.phoneModel = "iPhone 15 Pro";
        phone1.brand = "Apple";
        phone1.price = 999.99;
        phone1.storage = 256;
        phone1.color = "Space Black";
        
        Phone phone2 = new Phone();
        phone2.phoneModel = "Galaxy S24";
        phone2.brand = "Samsung";
        phone2.price = 899.99;
        phone2.storage = 512;
        phone2.color = "Onyx Black";
        
        Phone phone3 = new Phone();
        phone3.phoneModel = "Pixel 8 Pro";
        phone3.brand = "Google";
        phone3.price = 799.99;
        phone3.storage = 256;
        phone3.color = "Obsidian";
        
        Phone[] phoneArr = new Phone[3];
        phoneArr[0] = phone1;
        phoneArr[1] = phone2;
        phoneArr[2] = phone3;
        
        // Book objects
        Book book1 = new Book();
        book1.bookId = 101;
        book1.title = "Java Programming";
        book1.author = "John Doe";
        book1.price = 29.99;
        book1.pages = 450;
        
        Book book2 = new Book();
        book2.bookId = 102;
        book2.title = "Data Structures";
        book2.author = "Jane Smith";
        book2.price = 35.50;
        book2.pages = 520;
        
        Book book3 = new Book();
        book3.bookId = 103;
        book3.title = "Web Development";
        book3.author = "Bob Wilson";
        book3.price = 24.99;
        book3.pages = 380;
        
        Book[] bookArr = new Book[3];
        bookArr[0] = book1;
        bookArr[1] = book2;
        bookArr[2] = book3;
    }
}
