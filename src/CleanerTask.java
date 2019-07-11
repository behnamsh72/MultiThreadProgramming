import java.util.Date;
import java.util.Deque;

public class CleanerTask extends Thread {

    /**
     * Data Structures that stores event
     */
    private Deque<Event> deque;

    /**
     * Constructor of a class
     *
     * @param deque
     */
    public CleanerTask(Deque<Event> deque) {
        this.deque = deque;

        //Stablish that this is a Daemon Thread
        setDaemon(true);
    }


    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date) {
        long difference;
        boolean delete;
        if (deque.size() == 0)
            return;
        delete = false;
        do {
            Event e = deque.getLast();
            difference = date.getTime() - e.getDate().getTime();
            if (difference > 10000) {
                System.out.printf("Cleaner: %s\n", e.getEvent());
                deque.removeLast();
                delete = true;
            }

        } while (difference > 10000);
        if (delete) {
            System.out.printf("Cleaner: Size of the Queue: %d\n", deque.size());
        }
    }
}
