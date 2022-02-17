import java.util.*;
import java.util.concurrent.*;

public class MyTask implements Runnable {

    private int number;
    private Double value;
    private Double result;
    private String line = "\033[1;32m=================================================\033[0m";

    public MyTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        try {
            value = new Random().nextDouble();
            result = value / 100000;
            System.out.println("\n\t ---> RUNNING THREAD WITH ID # " + number + ": ");
            System.out.println("\n" + line + "\n\t The distance to object is: \n\t >>> " + result + " m.\n" + line);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        try {
            System.out.println("\nStarting test application...");
            for (int i = 0; i < 25; i++) {
                service.execute(new MyTask(i + 1));
                if (i == 25) {
                    System.out.println("\n\n\t The application has finished. Goodbye!");
                }
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
