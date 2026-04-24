package Ex3;

import java.util.Scanner;

public class Ex3_Menu {
    static Scanner sc = new Scanner(System.in);
    static String currentLocation = "";
    
    public static void main(String[] args) {
        mainMenu();
    }
    
    static void mainMenu() {
        while (true) {
            System.out.println("\nPhone Setting:");
            System.out.println("1. General >");
            System.out.println("2. Wi-Fi >");
            System.out.println("3. Bluetooth >");
            System.out.println("4. Mobile Data >");
            System.out.println("5. Hotspot >");
            System.out.println("6. Notification >");
            System.out.println("0. Quit");
            System.out.print("Choice: ");
            
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    generalMenu();
                    break;
                case 2:
                    wifiMenu();
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    unavailableMenu(choice);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    static void generalMenu() {
        while (true) {
            System.out.println("\nGeneral:");
            System.out.println("1. About >");
            System.out.println("2. Software update >");
            System.out.println("3. Storage >");
            System.out.println("0. Back");
            System.out.print("Choice: ");
            
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    aboutMenu();
                    break;
                case 2:
                    softwareUpdateMenu();
                    break;
                case 3:
                    unavailableMenu(3);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    static void aboutMenu() {
        System.out.println("\nGeneral > About:");
        System.out.println("Name: iPhone");
        System.out.println("Model: IXs");
        System.out.println("Version: 18.5");
        System.out.println("0. Back");
        System.out.print("Choice: ");
        sc.nextInt();
    }
    
    static void softwareUpdateMenu() {
        System.out.println("\nGeneral > Software Update:");
        System.out.println("======================");
        System.out.println("Software is up to date");
        System.out.println("======================");
        System.out.println("0. Back");
        System.out.print("Choice: ");
        sc.nextInt();
    }
    
    static void wifiMenu() {
        while (true) {
            System.out.println("\nWi-Fi:");
            System.out.println("Status: On");
            System.out.println("Network: I-Coffee");
            System.out.println("1. Other networks >");
            System.out.println("0. Back");
            System.out.print("Choice: ");
            
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    otherNetworksMenu();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    static void otherNetworksMenu() {
        System.out.println("\nWi-Fi > Other networks:");
        System.out.println("Bayon coffee *****");
        System.out.println("Angkor coffee **");
        System.out.println("Brown coffee ****");
        System.out.println("Koi *");
        System.out.println("0. Back");
        System.out.print("Choice: ");
        sc.nextInt();
    }
    
    static void unavailableMenu(int option) {
        System.out.println("\n============================");
        System.out.println("The Feature is not available");
        System.out.println("============================");
        System.out.println("0. Back");
        System.out.print("Choice: ");
        sc.nextInt();
    }
}
