package assignment;

public class Question2 {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public void addWithBlock() {
        synchronized (this) {
            count += 2;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Question2 obj = new Question2();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                obj.increment();
                obj.addWithBlock();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();t2.start();
        t1.join();t2.join();

        System.out.println("Final Count: " + obj.count);
    }
}
