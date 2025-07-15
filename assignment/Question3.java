package assignment;

public class Question3 {
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException _) {}
            flag = true;
            System.out.println("Writer: flag set to true");
        });

        Thread reader = new Thread(() -> {
            System.out.println("Reader: waiting for flag...");
            while (!flag) {
                // wait wait
            }
            System.out.println("Reader: detected flag = true");
        });

        reader.start();
        writer.start();
    }
}
