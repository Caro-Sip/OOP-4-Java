package exercise4;

import java.io.File;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        File note = new File("exercise4/myNote.txt");
        MyNote myNote = new MyNote(note);

        int input;

        while(true){
            printMenu();
            System.out.print("Choose an option: ");
            input = sc.nextInt();
            sc.nextLine();

            switch(input){
                case 1:
                    System.out.println("==== View note ====");
                    myNote.printNote();
                    break;
                case 2:
                    System.out.println("==== Edit following note ====");
                    editNote(myNote, sc);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

    }

    static void printMenu(){
        System.out.println("==== Menu ====");
        System.out.println("1. View my note");
        System.out.println("2. Edit");
        System.out.println("3. Quit");
    }

    static void editNote(MyNote myNote, Scanner sc){
        boolean editing = true;
        while(editing){
            myNote.printNote();
            myNote.editMenu();
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    System.out.println("Input a string for line #" + (myNote.lines + 1) + ":");
                    String line = sc.nextLine();
                    myNote.addNewLine(line);
                    break;
                case 2:
                    System.out.print("Update line number: ");
                    int lineNum = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Input new content for line #" + lineNum + ":");
                    String newContent = sc.nextLine();
                    myNote.updateLine(lineNum, newContent);
                    break;
                case 3:
                    System.out.print("Delete line number: ");
                    int delLineNum = sc.nextInt();
                    sc.nextLine();
                    myNote.deleteLine(delLineNum);
                    break;
                case 4:
                    editing = false;
                    System.out.println("Exiting edit menu.\n");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
