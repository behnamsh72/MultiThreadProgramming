import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetworkConnectionLoader implements Runnable {
    @Override
    public void run() {
        System.out.printf("Begining NetworkConnection loading:%s\n",new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Wirtes a message
        System.out.printf("NetworkConnection loading has finished:%s\n",new Date());

    }
}
