import java.util.concurrent.TimeUnit;

public class SafeMain {

    public static void main(String[] args) {
        SafeTask safeTask = new SafeTask();
        for (int i = 0; i < 2 * Runtime.getRuntime().availableProcessors(); i++) {
            Thread thread = new Thread(safeTask);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.start();
        }
    }
}
