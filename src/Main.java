import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        //Creates the Task
        Task task=new Task();
        Thread thread=new Thread(task);
        //sets the uncaught Exception handler
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        //Starts the thread
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread has finished\n");
    }
}
