import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        MyThreadFactory factory = new MyThreadFactory("My Thread Factory");
        Task task = new Task();
        Thread thread;
        System.out.printf("Starting the Threads\n");
        for (int i = 0; i < 10; i++) {
            thread = factory.newThread(task);
            thread.start();
        }

        System.out.printf("Factory Stats:\n");
        System.out.printf("%s\n", factory.getStats());

    }
}