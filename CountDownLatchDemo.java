import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(50);
        for (int i = 0; i < 50; i++) {
            int finalI = i;
            new Thread(()->{
                System.out.println("Latch count: " + latch.getCount());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                latch.countDown();
            }).start();
        }

        latch.await();
        System.out.println("Finis");

    }
}
