package lab09;
import java.lang.Thread;

public class thread {
    public static void main(){
        new Thread() {
                @Override
            public void run(){
                for(int i = 0; i < 1000; i++);
            }
        }.start();
    
        Thread t1 = new Thread(){

        };
        t1.start();

        new Thread(() -> System.out.println("Thread lambda")).start();
    }
}