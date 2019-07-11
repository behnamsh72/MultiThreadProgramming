import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ConsoleClock clock=new ConsoleClock();
        Thread thread=new Thread(clock);

        //Start the Thread
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
