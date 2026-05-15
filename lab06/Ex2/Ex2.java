package Ex2;

import java.util.Scanner;

public class Ex2{
    public static void main(String[] args){
        Math math = new Math();
        
        // ===== DIRECT TESTING =====
        System.out.println("===== SUM TESTS =====");
        System.out.println("sum(5, 3) = " + math.sum(5, 3));
        System.out.println("sum(10, 20, 30) = " + math.sum(10, 20, 30));
        System.out.println("sum([1, 2, 3, 4, 5]) = " + math.sum(new int[]{1, 2, 3, 4, 5}));
        
        System.out.println("\n===== MULTIPLY TESTS =====");
        System.out.println("multiply(4, 5) = " + math.multiply(4, 5));
        System.out.println("multiply(2, 3, 4) = " + math.multiply(2, 3, 4));
        System.out.println("multiply([2, 3, 4]) = " + math.multiply(new int[]{2, 3, 4}));
        
        System.out.println("\n===== MAX TESTS =====");
        System.out.println("max(10, 20, 15) = " + math.max(10, 20, 15));
        System.out.println("max(50, 25, 75, 30) = " + math.max(50, 25, 75, 30));
        System.out.println("max([12, 45, 23, 67, 34]) = " + math.max(new int[]{12, 45, 23, 67, 34}));
        
        System.out.println("\n===== MIN TESTS =====");
        System.out.println("min(10, 20, 15) = " + math.min(10, 20, 15));
        System.out.println("min(50, 25, 75, 30) = " + math.min(50, 25, 75, 30));
        System.out.println("min([12, 45, 23, 67, 34]) = " + math.min(new int[]{12, 45, 23, 67, 34}));
        
        System.out.println("\n===== AVERAGE TESTS =====");
        System.out.println("average(10, 20) = " + math.average(10, 20));
        System.out.println("average(15, 25, 35) = " + math.average(15, 25, 35));
        System.out.println("average(10, 20, 30, 40) = " + math.average(10, 20, 30, 40));
        System.out.println("average([10, 20, 30, 40]) = " + math.average(new int[]{10, 20, 30, 40}));
        
        // ===== INTERACTIVE MENU (Comment out if using tests only) =====
        Scanner sc = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n==== Menu ===");
            System.out.println("1. Sum of two values");
            System.out.println("2. Sum of three values");
            System.out.println("3. Sum of many values");
            System.out.println("4. Multiply of two values");
            System.out.println("5. Multiply of three values");
            System.out.println("6. Multiply of many values");
            System.out.println("7. Max of two values");
            System.out.println("8. Max of three values");
            System.out.println("9. Max of many values");
            System.out.println("10. Min of two values");
            System.out.println("11. Min of three values");
            System.out.println("12. Min of many values");
            System.out.println("13. Average of two values");
            System.out.println("14. Average of three values");
            System.out.println("15. Average of many values");
            System.out.println("16. Quit");
            System.out.print("Choose an option: ");
            
            choice = sc.nextInt();
              
            switch(choice) {
                case 1:
                    System.out.print("Enter two values: ");
                    int a = sc.nextInt(), b = sc.nextInt();
                    System.out.println("Sum: " + math.sum(a, b));
                    break;
                case 2:
                    System.out.print("Enter three values: ");
                    int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
                    System.out.println("Sum: " + math.sum(x, y, z));
                    break;
                case 3:
                    System.out.print("Enter array size: ");
                    int size = sc.nextInt();
                    int[] arr = new int[size];
                    System.out.print("Enter values: ");
                    for (int i = 0; i < size; i++) arr[i] = sc.nextInt();
                    System.out.println("Sum: " + math.sum(arr));
                    break;
                case 4:
                    System.out.print("Enter two values: ");
                    a = sc.nextInt(); b = sc.nextInt();
                    System.out.println("Multiply: " + math.multiply(a, b));
                    break;
                case 5:
                    System.out.print("Enter three values: ");
                    x = sc.nextInt(); y = sc.nextInt(); z = sc.nextInt();
                    System.out.println("Multiply: " + math.multiply(x, y, z));
                    break;
                case 6:
                    System.out.print("Enter array size: ");
                    size = sc.nextInt();
                    arr = new int[size];
                    System.out.print("Enter values: ");
                    for (int i = 0; i < size; i++) arr[i] = sc.nextInt();
                    System.out.println("Multiply: " + math.multiply(arr));
                    break;
                case 7:
                    System.out.print("Enter two values: ");
                    a = sc.nextInt(); b = sc.nextInt();
                    System.out.println("Max of 2: " + java.lang.Math.max(a, b));
                    break;
                case 8:
                    System.out.print("Enter three values: ");
                    x = sc.nextInt(); y = sc.nextInt(); z = sc.nextInt();
                    System.out.println("Max: " + math.max(x, y, z));
                    break;
                case 9:
                    System.out.print("Enter array size: ");
                    size = sc.nextInt();
                    arr = new int[size];
                    System.out.print("Enter values: ");
                    for (int i = 0; i < size; i++) arr[i] = sc.nextInt();
                    System.out.println("Max: " + math.max(arr));
                    break;
                case 10:
                    System.out.print("Enter two values: ");
                    a = sc.nextInt(); b = sc.nextInt();
                    System.out.println("Min of 2: " + java.lang.Math.min(a, b));
                    break;
                case 11:
                    System.out.print("Enter three values: ");
                    x = sc.nextInt(); y = sc.nextInt(); z = sc.nextInt();
                    System.out.println("Min: " + math.min(x, y, z));
                    break;
                case 12:
                    System.out.print("Enter array size: ");
                    size = sc.nextInt();
                    arr = new int[size];
                    System.out.print("Enter values: ");
                    for (int i = 0; i < size; i++) arr[i] = sc.nextInt();
                    System.out.println("Min: " + math.min(arr));
                    break;
                case 13:
                    System.out.print("Enter two values: ");
                    a = sc.nextInt(); b = sc.nextInt();
                    System.out.println("Average: " + math.average(a, b));
                    break;
                case 14:
                    System.out.print("Enter three values: ");
                    x = sc.nextInt(); y = sc.nextInt(); z = sc.nextInt();
                    System.out.println("Average: " + math.average(x, y, z));
                    break;
                case 15:
                    System.out.print("Enter array size: ");
                    size = sc.nextInt();
                    arr = new int[size];
                    System.out.print("Enter values: ");
                    for (int i = 0; i < size; i++) arr[i] = sc.nextInt();
                    System.out.println("Average: " + math.average(arr));
                    break;
                case 16:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 16);
        
        sc.close();
    }
}