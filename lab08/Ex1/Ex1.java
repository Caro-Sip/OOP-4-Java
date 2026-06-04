package Ex1;

import java.util.Scanner;

public class Ex1 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        GridManagement grid = new GridManagement();
        
        while(true){
            System.out.println(":::: The GRID ::::\n");
            try{
                grid.displayGrid();
            } catch(Exception e){
                e.printStackTrace();
            }

            System.out.println();

            printMenu();
            switch(getIntInput("Choose an opt:")){
                case 1:{
                    int v = getIntInput("Choose a value(0-9): ",0,9);
                    int c = getIntInput("Choose a column: ",0,6);
                    int r = getIntInput("Choose a row: ",0,6);
                    grid.updateCell(r,c,v);
                    break;
                }
                case 2:{
                    int values[] = new int[7];
                    int r = getIntInput("Choose a row: ",0,6);
                    for(int i=0;i<7;i++){
                        values[i] = getIntInput("Choose value at index " + i +": ",0,9);
                    }
                    
                    grid.insertAtRow(r, values);
                    break;
                }
                case 3:{
                    int c = getIntInput("Choose a column: ",0,6);
                    int values[] = new int[7];
                    for(int i=0;i<7;i++){
                        values[i] = getIntInput("Choose value at index " + i +": ",0,9);
                    }
                    grid.insertAtColumn(c, values);
                    break;
                }
                case 4:{
                    int r = getIntInput("Choose a row: ",0,6);
                    grid.clearAtRow(r);
                    break;
                }
                case 5:{
                    int c = getIntInput("Choose a column: ",0,6);
                    grid.clearAtColumn(c);
                    break;
                }
                case 6:
                    grid.clear();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Error: invalid range");
                    break;
            }
            System.out.println();
        }
    }

    static void printMenu(){
        System.out.println("1. Update a single cell");
        System.out.println("2. Insert at a row");
        System.out.println("3. Insert at a column");
        System.out.println("4. Insert Clear at a row");
        System.out.println("5. Clear at a column");
        System.out.println("6. Clear all");
        System.out.println("7. Quit");
    }
    
    public static int getIntInput(String prompt) {
        int value = 0;
        boolean validInput = false;
        
        while (!validInput) {
            try {
                System.out.print(prompt);
                value = scanner.nextInt();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid integer.");
                scanner.nextLine(); 
            }
        }
        return value;
    }
    
    public static int getIntInput(String prompt, int min, int max) {
        int value = 0;
        boolean validInput = false;
        
        while (!validInput) {
            try {
                System.out.print(prompt);
                value = scanner.nextInt();
                if (value < min || value > max){
                    System.out.println("Error: Please enter a number between " + min + " and " + max);
                } else {
                    validInput = true;
                }
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid integer.");
                scanner.nextLine(); 
            }
        }
        return value;
    }
}
