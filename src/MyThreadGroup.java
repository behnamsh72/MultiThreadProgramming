public class MyThreadGroup extends ThreadGroup{
    public MyThreadGroup(String name) {
        super(name);
    }
    /**
     * Method for process the uncaught exceptions
     */
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("The Thread %s has thrown an Exception\n",t.getId());
        e.printStackTrace(System.out);
        System.out.printf("Terminating the rest of the threads\n");
        interrupt();
    }
}
