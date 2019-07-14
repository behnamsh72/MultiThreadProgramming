

public class Main {
    public static void main(String[] args) {
        int numberOfThreads = 2 * Runtime.getRuntime().availableProcessors();
        MyThreadGroup threadGroup = new MyThreadGroup("My ThreadGroup");
        Task task = new Task();

        //Create the thread objects associated to the thread group
        for (int i = 0; i < numberOfThreads; i++) {
            Thread t = new Thread(threadGroup, task);
            t.start();
        }

        System.out.printf("Number of threads: %d\n", threadGroup.activeCount());
        System.out.printf("Information about the thread group\n");
        threadGroup.list();

        //Write information about the status of the Thread objects to the console

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (int i = 0; i < threadGroup.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
        }


    }
}
