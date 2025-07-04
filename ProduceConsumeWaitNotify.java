import java.util.Scanner;

public class ProduceConsumeWaitNotify {
    public static void main(String[] args) throws InterruptedException {
        ProduceConsumeWaitNotify pcwn = new ProduceConsumeWaitNotify();

        Thread producingThread = new Thread(()->{
            try {
                pcwn.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumingThread = new Thread(()->{
            try {
                pcwn.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producingThread.start();consumingThread.start();
        producingThread.join();consumingThread.join();
    }

    private void produce() throws InterruptedException {
        synchronized (this){
            System.out.println("Producing");
            wait();
            System.out.println("Resumed producing");
        }
    }

    private void consume() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(1000);
        synchronized (this) {
            System.out.println("Waiting for input");
            scanner.nextLine();
            System.out.println("Consumed, producer can continue");
            notify();
        }
    }
}
