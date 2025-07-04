import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLock {
    public static Integer i1 = 0;
    public static Integer i2 = 0;
    static ReentrantLock lock1 = new ReentrantLock();
    static ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 2000; i++) {
                increment();
            }
        }, "Increment Thread 1");

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 2000; i++) {
                increment();
            }
        }, "Increment Thread 2");

        Thread t3 = new Thread(()->{
            for (int i = 0; i < 2000; i++) {
                decrement();
            }
        }, "Decrement Thread 1");

        Thread t4 = new Thread(()->{
            for (int i = 0; i < 2000; i++) {
                decrement();
            }
        }, "Decrement Thread 4");

        t1.start();t3.start();t2.start();t4.start();
        t1.join();t2.join();t3.join();t4.join();

        System.out.println("i1: " + i1 + "\ni2: " + i2);
    }

    private static void increment() {
        lock1.lock();
        i1++;
        lock1.unlock();
    }

    private static void decrement() {
        lock2.lock();
        i2--;
        lock2.unlock();
    }
}
