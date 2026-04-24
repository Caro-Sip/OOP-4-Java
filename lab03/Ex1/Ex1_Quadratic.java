package Ex1;


import java.util.Scanner;

public class Ex1_Quadratic {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Program for calculating roots of quadratic equation ax^2+ bx +c=0");
        System.out.print("Input value of a: ");
        int a = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Input value of b: ");
        int b = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Input value of c");
        int c = scanner.nextInt();
        scanner.nextLine();

        int delta = b*b - 4*a*c;

        if (delta < 0){
            System.out.println("Error: roots are complex like your heart");
            scanner.close();
            return;
        }
        if (delta == 0){
            double x = (-b)/(2*a);
            System.out.println("Root is duplicate: x = " + String.format("%.2f", x));
        }
        else{         
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            
            System.out.println("Roots are:");
            System.out.println("x1 = " + String.format("%.2f", x1));
            System.out.println("x2 = " + String.format("%.2f", x2));
        }


        scanner.close();
    }
}
