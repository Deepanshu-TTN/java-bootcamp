package assignment;

import static java.lang.Thread.sleep;

public class Question1 {
    public static void main(String[] args) throws InterruptedException {
            Thread t1 = new ThreadTask();
            Thread t2 = new Thread(new RunnableTask());

            t1.start();t2.start();

            t1.join();t2.join();
    }
}

class ThreadTask extends Thread{
    @Override
    public void run() {
        System.out.println("Thread started,,,");
        try {
            sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread finished!");
    }
}

class RunnableTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Runnable started,,,");
        try {
            sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Runnable finished!");
    }
}