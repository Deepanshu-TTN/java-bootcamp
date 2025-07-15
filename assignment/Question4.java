package assignment;

public class Question4 {
    private static final Object Lock1 = new Object();
    private static final Object Lock2 = new Object();

    public static void method1(){
        synchronized (Lock1) {
            System.out.println("Thread 1: Holding Lock1...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException _) {}
            System.out.println("Thread 1: Waiting for Lock2...");
            synchronized (Lock2) {
                System.out.println("Thread 1: Acquired Lock2!");
            }
        }
    }

    public static void method2(){
        synchronized (Lock2) {
            System.out.println("Thread 2: Holding Lock2...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException _) {}
            System.out.println("Thread 2: Waiting for Lock1...");
            synchronized (Lock1) {
                System.out.println("Thread 2: Acquired Lock1!");
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(Question4::method1);
        Thread thread2 = new Thread(Question4::method2);

        thread1.start();
        thread2.start();
    }
}
