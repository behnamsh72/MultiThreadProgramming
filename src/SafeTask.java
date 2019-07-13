import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable{


    /**
     * ThreadLocal shared between the Thread objects
     */
    private static ThreadLocal<Date> startDate=new ThreadLocal<>(){
        protected Date initialValue(){
            return new Date();
        }
    };
    @Override
    public void run() {
        //Writes the start date
        System.out.printf("Starting thread: %s : %s\n",Thread.currentThread().getId(),startDate.get());

        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Thread finished: %s : %s\n",Thread.currentThread().getId(),startDate.get());

    }
}
