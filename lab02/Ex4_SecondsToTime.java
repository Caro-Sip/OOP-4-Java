package lab02;

public class Ex4_SecondsToTime {
    public static void main(String[] args){
        java.util.Scanner s = new java.util.Scanner(System.in);
        
        System.out.print("Input number of seconds: ");
        int seconds = s.nextInt();
        s.nextLine();
        s.close();

        int[] time = new int[3];

        time[0] = (int) seconds / 3600 % 24; // Hours
        int remainMinutes = seconds % 3600; 
        time[1] = (int) remainMinutes / 60; // Minutes
        time[2] = (int) remainMinutes % 60; // Seconds

        System.out.printf("Time corresponding to %d is %d:%d:%d\n",seconds, time[0],time[1],time[2]);
    }
}
