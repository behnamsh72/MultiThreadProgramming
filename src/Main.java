import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ParkingCash cash=new ParkingCash();
        ParkingStats stats=new ParkingStats(cash);

        System.out.printf("Parking simulator");

        int numberOfSensors=2*Runtime.getRuntime().availableProcessors();
        Thread[] threads=new Thread[numberOfSensors];
        for(int i=0;i<numberOfSensors;i++){
            Sensor sensor=new Sensor(stats);
            Thread thread=new Thread(sensor);
            thread.start();
            threads[i]=thread;
        }
        for(int i=0;i<numberOfSensors;i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Number of cars: %d\n",stats.getNumberCars());
        System.out.printf("Number of motorcycles:%d\n",stats.getNumberMotorcycles());
        cash.close();

    }
}