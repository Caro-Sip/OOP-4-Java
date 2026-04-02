package lab04.exercise5;

import java.util.Scanner;

public class Ex5 {
    static class Store {
        private Album[] albums;
        private int albumCount;

        Store() {
            this.albums = new Album[100];
            this.albumCount = 0;
        }

        void createAlbum(String title, String genre) {
            if (albumCount < albums.length) {
                albums[albumCount++] = new Album(title, genre);
                System.out.println("Album created successfully!");
            } else {
                System.out.println("Store is full!");
            }
        }

        void viewStore() {
            System.out.println("====== Music Store ======");
            for (int i = 0; i < albumCount; i++) {
                albums[i].displaySongs();
            }
        }

        void addSongToAlbum(int albumIndex, String title, String singer, String length, double price) {
            if (albumIndex >= 0 && albumIndex < albumCount) {
                albums[albumIndex].addSong(title, singer, length, price);
            } else {
                System.out.println("Invalid album!");
            }
        }

        void displayAlbumList() {
            System.out.println("Select following album:");
            for (int i = 0; i < albumCount; i++) {
                System.out.println((i + 1) + ". " + albums[i].getTitle());
            }
        }

        int getAlbumCount() {
            return albumCount;
        }

        Album getAlbum(int index) {
            if (index >= 0 && index < albumCount) {
                return albums[index];
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Store store = new Store();

        // Create sample albums
        store.createAlbum("Skull 1", "Hiphop");
        store.createAlbum("Skull 2", "Hiphop");
        store.createAlbum("Reborn", "Hiphop");

        // Add songs to albums
        store.addSongToAlbum(0, "Solo", "Vannda", "3mins", 5.0);
        store.addSongToAlbum(0, "QueenBee", "Vannda", "5mins", 12.0);
        store.addSongToAlbum(2, "How about now", "G-Devith", "2mins", 10.0);

        int choice;
        do {
            System.out.println("\n====== Menu ======");
            System.out.println("1. View a music store");
            System.out.println("2. Add a song");
            System.out.println("3. Create an album");
            System.out.println("4. Quit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    store.viewStore();
                    break;
                case 2:
                    store.displayAlbumList();
                    System.out.print("Choose an opt: ");
                    int albumOpt = sc.nextInt();
                    sc.nextLine();
                    
                    if (albumOpt > 0 && albumOpt <= store.getAlbumCount()) {
                        System.out.println("===== Add a new song ====");
                        System.out.print("Song title: ");
                        String title = sc.nextLine();
                        System.out.print("Signer: ");
                        String singer = sc.nextLine();
                        System.out.print("Length: ");
                        String length = sc.nextLine();
                        System.out.print("Price: ");
                        double price = sc.nextDouble();
                        
                        store.addSongToAlbum(albumOpt - 1, title, singer, length, price);
                    } else {
                        System.out.println("Invalid album!");
                    }
                    break;
                case 3:
                    System.out.println("===== Create new album ====");
                    System.out.print("Album title: ");
                    String albumTitle = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre = sc.nextLine();
                    store.createAlbum(albumTitle, genre);
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
