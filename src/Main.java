import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Thread task=new PrimeGenerator();
        task.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();

        System.out.printf("Main:Status of the thread : %s\n",task.getState());
        System.out.printf("Main: isInterrupted: %s\n",task.isInterrupted());
        System.out.printf("Main: isAlive: %s\n",task.isAlive());

    }
}
