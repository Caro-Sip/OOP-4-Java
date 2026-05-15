package Ex1;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args){
        Math math = new Math();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        // System.out.println(math.reverseNumber(12345));
        // System.out.println(math.roundedNumber(3.14));
        // System.out.println(math.roundedNumber(3.54));
        // System.out.println("labubu");
        // System.out.println(math.countDistinct(new int[]{0,0,0,1,2,2,1}));
        // System.out.println(math.decimalToBinary(4));

        do {
            System.out.println("\n==== Menu ===");
            System.out.println("1. Reverse a number");
            System.out.println("2. Rounded number");
            System.out.println("3. Count distinct number");
            System.out.println("4. Decimal to Binary");
            System.out.println("5. Quit");
            System.out.print("Choose an opt: ");

            choice = sc.nextInt();

            switch(choice) {
            case 1:
                System.out.println("\n::: Reverse a number :::");
                System.out.print("Input number: ");
                int num = sc.nextInt();
                System.out.println("Output is: " + math.reverseNumber(num));
                break;
                
            case 2:
                System.out.println("\n::: Rounded number :::");
                System.out.print("Input decimal number: ");
                double dnum = sc.nextDouble();
                System.out.println("Output is: " + math.roundedNumber(dnum));
                break;
                
            case 3:
                System.out.println("\n::: Count distinct number :::");
                System.out.print("Input array size: ");
                int size = sc.nextInt();
                int[] arr = new int[size];
                System.out.print("Input values: ");
                for (int i = 0; i < size; i++) {
                    arr[i] = sc.nextInt();
                }
                System.out.println("Output is: " + math.countDistinct(arr));
                break;
                
                case 4:
                    System.out.println("\n::: Decimal to Binary :::");
                    System.out.print("Input decimal number: ");
                    int dec = sc.nextInt();
                    System.out.println("Output is: " + math.decimalToBinary(dec));
                    break;
                    
                case 5:
                    System.out.println("Exiting...");
                    break;
                    
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
        
        sc.close();
    }
}
