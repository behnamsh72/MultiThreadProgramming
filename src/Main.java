import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

    FileSearch searcher=new FileSearch("/home/behnam/","log.txt");
    Thread thread=new Thread(searcher);

    //start the thread
    thread.start();

    //wait for 10 seconds
        try {
            TimeUnit.SECONDS.sleep(5);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Interrupts the thread
        thread.interrupt();
    }
}
