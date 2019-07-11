import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Deque<Event> deque= new ConcurrentLinkedDeque<>();
        //Creates the three WriterTask and starts them
        WriterTask writerTask=new WriterTask(deque);
        for(int i=0;i<Runtime.getRuntime().availableProcessors();i++){
            Thread thread=new Thread(writerTask);
            thread.start();
        }


        //Creates a cleaner task and starts them
        CleanerTask cleanerTask=new CleanerTask(deque);
        cleanerTask.start();
    }
}
