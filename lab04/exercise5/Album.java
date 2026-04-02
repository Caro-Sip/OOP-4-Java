package lab04.exercise5;

public class Album {
    private String title;
    private String genre;
    private Song[] songs;
    private int songCount;

    public Album(String title, String genre) {
        this.title = title;
        this.genre = genre;
        this.songs = new Song[100];
        this.songCount = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public void addSong(String title, String singer, String length, double price) {
        if (songCount < songs.length) {
            songs[songCount++] = new Song(title, singer, length, price);
            System.out.println("A new song added to the album");
        } else {
            System.out.println("Album is full!");
        }
    }

    public void displaySongs() {
        System.out.println("Album: " + title);
        if (songCount == 0) {
            System.out.println("None of song");
            return;
        }
        System.out.println(String.format("| %s | %-20s | %-12s | %-8s | %-8s |", 
            "No", "Title", "Singer", "Length", "Price"));
        
        for (int i = 0; i < songCount; i++) {
            songs[i].display(i + 1);
        }
    }

    public int getSongCount() {
        return songCount;
    }
}