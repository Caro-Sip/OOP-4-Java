package exercise6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex6 {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final File USER_FILE = new File("exercise6/user.txt");

    public static void main(String[] args) {
        ensureFile(USER_FILE);

        while (true) {
            printMenu();
            int option = readInt("Choose an option: ");

            switch (option) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    SCANNER.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("==== Menu ====");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Quit");
    }

    private static void register() {
        System.out.println("==== Register a new user ====");
        String firstName = readLine("First Name: ");
        String lastName = readLine("Last Name: ");
        String username = readLine("Username: ");
        String email = readLine("Email: ");
        String password = readLine("Password: ");

        User user = new User(firstName, lastName, username, email, password);
        appendLine(USER_FILE, user.toStorageString());
        System.out.println("You are successfully registered~");
    }

    private static void login() {
        System.out.println("==== Login ====");
        List<User> users = loadUsers();

        while (true) {
            String identity = readLine("Email or Username: ");
            String password = readLine("Password: ");

            User matched = findUser(users, identity, password);
            if (matched == null) {
                System.out.println("User not found. Please try again");
                continue;
            }

            printUserInfo(matched);
            return;
        }
    }

    private static void printUserInfo(User user) {
        System.out.println("========== User Info ==========");
        System.out.println("Hi " + user.getFirstName() + " " + user.getLastName() + ",");
        System.out.println("Your username is: " + user.getUsername());
        System.out.println("Your email is: " + user.getEmail());
    }

    private static User findUser(List<User> users, String identity, String password) {
        for (User user : users) {
            if ((user.getEmail().equals(identity) || user.getUsername().equals(identity))
                    && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    private static List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                User user = User.fromStorageString(line);
                if (user != null) {
                    users.add(user);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to read user file.");
        }
        return users;
    }

    private static void ensureFile(File file) {
        try {
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Failed to create file: " + file.getPath());
        }
    }

    private static void appendLine(File file, String line) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Failed to write file: " + file.getPath());
        }
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return SCANNER.nextLine().trim();
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(SCANNER.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }
}
