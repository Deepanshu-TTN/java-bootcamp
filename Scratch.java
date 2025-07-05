import java.util.List;
import java.util.stream.IntStream;

public class Scratch {
    public static void main(String[] args) {
//        new FileLogger().demo();
        List<Integer> nums = List.of(2,4,6,8,9,10,12);

        System.out.println("Take while");
        // takeWhile method - passes elements from the stream until a condition fails
        nums.stream().takeWhile(e->e%2==0).forEach(System.out::println); //2,4,6,8

        System.out.println("\nDrop while");
        // dropWhile method - passes elements from the stream until a condition fails
        nums.stream().dropWhile(e->e%2==0).forEach(System.out::println); //9,10,12

        System.out.println("\nRange");
        // range method - inclusive of 1 and exclusive of 4
        IntStream.range(1,4).map(nums::get).forEach(System.out::println); //4,6,8

        System.out.println("\nClosed Range");
        // rangeClosed method - inclusive of 1 and 4
        IntStream.rangeClosed(1,4).map(nums::get).forEach(System.out::println);

        // all primes between 2-100
        List<Integer> primes = IntStream.rangeClosed(2, 100)
                .filter(n -> IntStream.range(2, n).allMatch(d -> n % d != 0))
                .boxed()
                .toList();
        System.out.println(primes);

        // first n(30) primes
        List<Integer> primes30 = IntStream.
                iterate(2,n -> n+1
                ).filter(n-> IntStream.
                        range(2,n).allMatch(d -> n % d != 0))
                .limit(30)
                .boxed()
                .toList();

        System.out.println(primes30);

    }
}

interface Logger {
    default void INFO(String message){
        log("INFO", message);
    }

    default void ERROR(String message){
        log("ERROR", message);
    }

    default void WARNING(String message){
        log("WARNING", message);
    }

    private void log(String level, String message){
        String formattedMessage = formatted(level, message);
        System.out.println(formattedMessage);
    }

    private static String formatted(String level, String message){
        return "[" + level + "]" + message;
    }
}

class FileLogger implements Logger {
    void demo() {
        INFO("File loaded");
        ERROR("File not found");
        WARNING("File already exists, overwriting.");
    }
}