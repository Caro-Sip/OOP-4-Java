package lab02;

import static java.lang.System.out;

import java.util.Scanner;

public class Ex5_Equation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        out.println("Program for calculating equation 1/x = 1/y + 1/z to find value of x");
        out.print("Please input y: ");
        double y = s.nextDouble();
        s.nextLine();

        out.print("Please input z: ");
        double z = s.nextDouble();
        s.nextLine();

        double x = (y*z)/(y+z);
        out.printf("Result x = %.2f\n", x);

        s.close();
    }
}
