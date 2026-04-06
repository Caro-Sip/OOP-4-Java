package exercise1;

import java.text.ParseException;
import java.util.Scanner;

public class Ex1 {
    static void printMenu(){
        System.out.println("==== Menu ====");
        System.out.println("1. Current Date and Time");
        System.out.println("2. Calculate days between two dates");
        System.out.println("3. Find the day of the week");
        System.out.println("4. Quit");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int input;

        do {
            printMenu();
            
            System.out.print("Choose an opt: ");
            input = sc.nextInt();
            sc.nextLine();

            System.out.println();

            switch(input){
                case 1:
                    System.out.println("Current datetime is: " + MyDate.getCurrentDate());
                    System.out.println();
                    break;
                case 2:
                    System.out.print("First date(dd/MM/yyyy): ");
                    String date1 = sc.nextLine();
                    System.out.println();
                    
                    System.out.print("Second date(dd/MM/yyyy): ");
                    String date2 = sc.nextLine();
                    System.out.println();

                    try {
                        System.out.println("Difference between two dates is: " + MyDate.calculateDaysBtwDates(date1, date2) + " days");
                        System.out.println();
                    }
                    catch (ParseException pe){
                        System.out.println("Please enter the date as dd/MM/yyyy");
                    }

                    break;
                case 3:
                    System.out.print("Input a date (dd/MM/yyyy): ");
                    String day = sc.nextLine();

                    try {
                        System.out.print("The day is: " + MyDate.findDay(day));
                        System.out.println();
                    }
                    catch (ParseException e) {
                        System.out.println("Please enter day ad dd/MM/yyy");
                    }

                    System.out.println();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Outside input range"); 
                    System.out.println();
                    break;
            }
        } while(input != 4);

        sc.close();
        System.out.println("Goodbye");
        return;
    }

}
