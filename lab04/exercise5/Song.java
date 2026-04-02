package lab04.exercise5;

public class Song {
    private String title;
    private String singer;
    private String length;
    private double price;

    public Song(String title, String singer, String length, double price) {
        this.title = title;
        this.singer = singer;
        this.length = length;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    public String getLength() {
        return length;
    }

    public double getPrice() {
        return price;
    }

    public void display(int index) {
        System.out.println(String.format("| %d | %-20s | %-12s | %-8s | $%-6.2f |", 
            index, title, singer, length, price));
    }
}