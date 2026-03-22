package lab02;

import java.util.Scanner;

public class Ex6_Prime {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.print("Input a number to check whether it is a prime number: ");
        int input = s.nextInt();
        s.nextLine();
        s.close();

        for(int i = 2; i*i <= input; i++){
            if (input % i == 0){
                System.out.println(input + " is not a prime number because it is divisible by " + i);
                return;
            }
        }
        System.out.println(input + " is a prime number");
    }
}
