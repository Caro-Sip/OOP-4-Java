package Ex2;

import java.util.Scanner;
import java.util.Random;
import java.util.HashSet;
import java.util.Arrays;

public class Ex2 extends NumberRandomizer{

    @Override
    int randomizeInBetween(int min, int max) {
        Random random = new Random();
        return min + random.nextInt(max - min + 1);
    }

    @Override
    int[] randomizeUniqueInBetween(int min, int max, int amount) {
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        Random random = new Random();
        
        // Ensure amount doesn't exceed possible unique numbers
        int range = max - min + 1;
        if (amount > range) {
            amount = range;
        }
        
        // Generate unique random numbers
        while (uniqueNumbers.size() < amount) {
            uniqueNumbers.add(min + random.nextInt(max - min + 1));
        }
        
        int[] result = new int[uniqueNumbers.size()];
        int index = 0;
        for (int num : uniqueNumbers) {
            result[index++] = num;
        }
        Arrays.sort(result);
        return result;
    }
    
    public static void main(String[] args){
        System.out.println("==== Sample Number Randomizer ====");
        Ex2 randomizer = new Ex2();
        
        System.out.println("Random number between 1 and 100: " + randomizer.randomizeInBetween(1, 100));
        System.out.println("5 unique random numbers between 1 and 20: " + Arrays.toString(randomizer.randomizeUniqueInBetween(1, 20, 5)));
        
        System.out.println("\n==== Number Randomizer ====");
        System.out.println("1. In between");
        System.out.println("2. Unique in between");
        System.out.println("3. Quit");
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();
        
        switch (option) {
            case 1:
                System.out.print("Enter min: ");
                int min = scanner.nextInt();
                System.out.print("Enter max: ");
                int max = scanner.nextInt();
                System.out.println("Random number: " + randomizer.randomizeInBetween(min, max));
                break;
            case 2:
                System.out.print("Enter min: ");
                int min2 = scanner.nextInt();
                System.out.print("Enter max: ");
                int max2 = scanner.nextInt();
                System.out.print("Enter amount: ");
                int amount = scanner.nextInt();
                System.out.println("Unique random numbers: " + Arrays.toString(randomizer.randomizeUniqueInBetween(min2, max2, amount)));
                break;
            case 3:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid option.");
        }
        
        scanner.close();
    }
}

