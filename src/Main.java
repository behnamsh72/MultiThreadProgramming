import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        DataSourcesLoader dataSourcesLoader=new DataSourcesLoader();
        Thread thread1=new Thread(dataSourcesLoader,"DataSourcesLoader");


        NetworkConnectionLoader networkConnectionLoader=new NetworkConnectionLoader();
        Thread thread2=new Thread(networkConnectionLoader,"NetworkConnectionLoader");
        thread1.start();
        thread2.start();



        //wait for the finalization of the two threads
        try {
            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: Configuration has been loaded: %s\n",new Date());
    }
}
