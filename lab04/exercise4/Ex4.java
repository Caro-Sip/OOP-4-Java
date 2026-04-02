package lab04.exercise4;

import java.util.Scanner;

public class Ex4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VideoManager manager = new VideoManager(100);

        // Add sample videos
        manager.addVideo("Prey Eh Kert", "sin sisamuth", "3:45", "Music");
        manager.addVideo("Pel Del Trov Yum", "Sinn Sisamouth", "4:20", "Music");
        manager.addVideo("Luoch Sneh Luoch Tuk", "Sinn Sisamouth", "5:10", "Music");

        int choice;
        do {
            System.out.println("\n==== Menu ===");
            System.out.println("1. Search");
            System.out.println("2. View all videos");
            System.out.println("3. Add a new video");
            System.out.println("4. Quit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("==== Video Search ====");
                    System.out.print("Input title: ");
                    String keyword = sc.nextLine();
                    manager.search(keyword);
                    break;
                case 2:
                    manager.viewAll();
                    break;
                case 3:
                    System.out.print("Input Title: ");
                    String title = sc.nextLine();
                    System.out.print("Input Uploader: ");
                    String uploader = sc.nextLine();
                    System.out.print("Input Length: ");
                    String length = sc.nextLine();
                    System.out.print("Input Type: ");
                    String type = sc.nextLine();
                    manager.addVideo(title, uploader, length, type);
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