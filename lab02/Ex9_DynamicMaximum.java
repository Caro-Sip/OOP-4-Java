package lab02;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex9_DynamicMaximum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        
        int index = 0;
        boolean addMore = true;
        
        while (addMore) {
            System.out.print("Input value in Array at index " + index + ": ");
            int value = s.nextInt();
            s.nextLine();
            numbers.add(value);
            
            System.out.print("Do you want to add more (y/n)?: ");
            String response = s.nextLine().trim().toLowerCase();
            
            if (response.equals("y")) {
                addMore = true;
                index++;
            } else {
                addMore = false;
            }
        }
        
        s.close();
        
        int max = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }
        
        System.out.println("The biggest number among in Array is: " + max);
    }
}
