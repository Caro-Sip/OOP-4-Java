package lab02;

import java.util.Scanner;

public class Ex8_Minimum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.print("Input value of A: ");
        int a = s.nextInt();
        
        System.out.print("Input value of B: ");
        int b = s.nextInt();
        
        System.out.print("Input value of C: ");
        int c = s.nextInt();
        
        System.out.print("Input value of D: ");
        int d = s.nextInt();
        
        System.out.print("Input value of E: ");
        int e = s.nextInt();
        
        s.close();

        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        if (d < min) min = d;
        if (e < min) min = e;
        
        System.out.println("The smallest number among A, B, C, D, and E is: " + min);
    }
}
