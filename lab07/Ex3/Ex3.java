package Ex3;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Ex3 extends TextRandomizer {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";

    @Override
    char randomizedACharacter() {
        Random random = new Random();
        return CHARACTERS.charAt(random.nextInt(CHARACTERS.length()));
    }

    @Override
    String randomizeAString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(randomizedACharacter());
        }
        return sb.toString();
    }

    @Override
    String[] randomizeStrings(int lenght, int amount) {
        String[] result = new String[amount];
        for (int i = 0; i < amount; i++) {
            result[i] = randomizeAString(lenght);
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("==== Sample Text Randomizer ====");
        Ex3 randomizer = new Ex3();
        
        System.out.println("Random character: " + randomizer.randomizedACharacter());
        System.out.println("Random string (length=10): " + randomizer.randomizeAString(10));
        System.out.println("3 random strings (length=8): " + Arrays.toString(randomizer.randomizeStrings(8, 3)));
        
        System.out.println("\n==== Text Randomizer ====");
        System.out.println("1. Random character");
        System.out.println("2. Random string");
        System.out.println("3. Random strings");
        System.out.println("4. Quit");
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();
        
        switch (option) {
            case 1:
                System.out.println("Random character: " + randomizer.randomizedACharacter());
                break;
            case 2:
                System.out.print("Enter length: ");
                int length = scanner.nextInt();
                System.out.println("Random string: " + randomizer.randomizeAString(length));
                break;
            case 3:
                System.out.print("Enter length: ");
                int len = scanner.nextInt();
                System.out.print("Enter amount: ");
                int amount = scanner.nextInt();
                System.out.println("Random strings: " + Arrays.toString(randomizer.randomizeStrings(len, amount)));
                break;
            case 4:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid option.");
        }
        
        scanner.close();
    }
}
