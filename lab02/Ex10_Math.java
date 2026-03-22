package lab02;

import java.util.Scanner;

public class Ex10_Math {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int option;
        boolean continueProgram = true;
        
        while (continueProgram) {
            displayMenu();
            option = getValidOption();
            
            if (option == 5) {
                System.out.println("Goodbye!");
                continueProgram = false;
            } else {
                performCalculation(option);
                continueProgram = askToContinue();
            }
        }
    }
    
    static void displayMenu() {
        System.out.println("=== Math Menu ===");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (x)");
        System.out.println("4. Division (/)");
        System.out.println("5. Quit");
    }
    
    static int getValidOption() {
        int option;
        while (true) {
            System.out.print("Please choose an option: ");
            if (sc.hasNextInt()) {
                option = sc.nextInt();
                if (option >= 1 && option <= 5) {
                    return option;
                } else {
                    System.out.println("Please choose an option again.");
                }
            } else {
                sc.nextLine(); // Clear invalid input
                System.out.println("Please choose an option again.");
            }
        }
    }
    
    static void performCalculation(int option) {
        System.out.print("Please input value A: ");
        double a = sc.nextDouble();
        
        System.out.print("Please input value B: ");
        double b = sc.nextDouble();
        
        double result = 0;
        String operation = "";
        
        switch (option) {
            case 1:
                result = add(a, b);
                operation = "A + B";
                break;
            case 2:
                result = subtract(a, b);
                operation = "A - B";
                break;
            case 3:
                result = multiply(a, b);
                operation = "A * B";
                break;
            case 4:
                result = divide(a, b);
                operation = "A / B";
                break;
        }
        
        System.out.println("Answer of " + operation + " = " + (int)result);
    }
    
    static double add(double a, double b) {
        return a + b;
    }
    
    static double subtract(double a, double b) {
        return a - b;
    }
    
    static double multiply(double a, double b) {
        return a * b;
    }
    
    static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero!");
            return 0;
        }
        return a / b;
    }
    
    static boolean askToContinue() {
        String response;
        while (true) {
            System.out.print("Do you want to continue? If no go to Menu.\nInput your answer (y/n): ");
            response = sc.next().toLowerCase();
            if (response.equals("y") || response.equals("yes")) {
                return true;
            } else if (response.equals("n") || response.equals("no")) {
                return false;
            } else {
                System.out.println("Please enter 'y' or 'n'.");
            }
        }
    }
}
