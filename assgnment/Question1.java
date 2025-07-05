package assgnment;

import java.util.stream.Stream;

public class Question1 {
    public static void main(String[] args) {
        Stream.iterate(0, i -> i < 10, i -> i+2)
                .forEach(System.out::println);
    }
}
