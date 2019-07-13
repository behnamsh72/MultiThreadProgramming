public class Task implements Runnable {
    @Override
    public void run() {
        //The next Instructions always throws and exception
        int number=Integer.parseInt("TTT");
        //This sentence will never executed
        System.out.printf("Number: %d ",number);
    }
}
