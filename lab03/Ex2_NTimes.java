package lab03;
import java.util.Scanner;

public class Ex2_NTimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many number to be input?");
        System.out.print("Number of input: ");
        int n = sc.nextInt();
        
        double[] numbers = new double[n];
        
        // Input numbers
        for (int i = 0; i < n; i++) {
            System.out.print("Value #" + (i + 1) + ": ");
            numbers[i] = sc.nextDouble();
        }
        
        // Calculate max, min, sum
        double max = numbers[0];
        double min = numbers[0];
        double sum = 0;
        
        for (double num : numbers) {
            if (num > max) max = num;
            if (num < min) min = num;
            sum += num;
        }
        
        double average = sum / n;
        
        System.out.println("Max: " + (int)max);
        System.out.println("Min: " + (int)min);
        System.out.println("Average: " + average);
        System.out.println("Sum: " + (int)sum);
        
        sc.close();
    }
}
