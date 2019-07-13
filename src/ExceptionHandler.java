public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    /**
     * Main method of the class. It process the uncaught exceptions throwed in a Thread
     *
     * @param t
     * @param e
     */
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("An Exception has been captured\n");
        System.out.printf("Thread : %s\n",t.getId());
        System.out.printf("Exception :%s : %s\n",e.getClass().getName(),e.getMessage());
        System.out.printf("Stack trace : \n");
        e.printStackTrace();
        System.out.printf("Thread status: %s\n",t.getState());
    }
}
