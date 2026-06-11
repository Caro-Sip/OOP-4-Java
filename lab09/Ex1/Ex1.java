package Ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<TaskProcess> taskList = new ArrayList<>();
        taskList.add(new TaskProcess(new Task("Format hard disk", 1000)));
        taskList.add(new TaskProcess(new Task("Download video", 6000)));
        taskList.add(new TaskProcess(new Task("Develop an app", 8000)));

        boolean running = true;
        while(running){
            printTasks(taskList);

            System.out.println("1. Add new task");
            System.out.println("2. Delete a task");
            System.out.println("3. Proceed tasks");
            System.out.println("0. Exit");
            System.out.print("Choose an opt: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            if(option == 1){
                System.out.print("Input task name: ");
                String name = scanner.nextLine();
                System.out.print("Input duration (ms): ");
                int duration = scanner.nextInt();
                scanner.nextLine();
                Task newTask = new Task(name, duration);
                taskList.add(new TaskProcess(newTask));
                System.out.println("Task added.\n");
            } 
            else if(option == 2){
                System.out.print("Task number to delete: ");
                int no = scanner.nextInt();
                scanner.nextLine();
                taskList.remove(no-1);
            }
            else if(option == 3){
                ArrayList<Integer> chosenTasks = new ArrayList<>(); 
                boolean addingTask = true;
                System.out.println("Select tasks to perform parallel process: ");
                while(addingTask) {
                    System.out.print("Input task No: ");
                    int number = scanner.nextInt();
                    scanner.nextLine();
                    if (number < 1 || number > taskList.size()) {
                        System.out.println("Invalid task number.");
                        continue;
                    }
                    chosenTasks.add(number-1);
                    System.out.print("Do you want to add more tasks? (y/n): ");
                    char answer = scanner.nextLine().charAt(0);

                    if(answer == 'n'){
                        addingTask = false;
                    }
                }

                System.out.println();

                ArrayList<Thread> threads = new ArrayList<>();
                for(int i : chosenTasks){
                    Thread t = new Thread(taskList.get(i));
                    threads.add(t);
                    t.start();
                }

                // wait for all threads to finish before continuing
                for (Thread t : threads) {
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Main thread interrupted while waiting for tasks.");
                    }
                }

                System.out.println("All selected tasks completed.\n");
            }
            else if(option == 0){
                running = false;
            }
            else {
                System.out.println("Invalid input");
            }
        }

        System.out.println("goodbye");

        scanner.close();
    }

    private static void printTasks(ArrayList<TaskProcess> taskList){
        System.out.println("::: Task Handler :::");
        for(int i = 0; i < 56; i++) System.out.print("=");
        System.out.println();

        System.out.printf("| %-3s| %-30s| %-16s|%n","No","Name","Duration");

        for(int i = 0; i < 56; i++) System.out.print("=");
        System.out.println();

        int j = 1;
        for(TaskProcess tp : taskList){
            System.out.printf("| %-3d| %-30s| %-10d mills|%n", j, tp.getTask().getName(), tp.getTask().getDuration());
            j++;
        }

        for(int i = 0; i < 56; i++) System.out.print("=");
        System.out.println();
    }
}

