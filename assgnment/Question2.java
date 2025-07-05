package assgnment;

import java.util.Optional;

public class Question2 {
    public static void main(String[] args) {
        Optional<String> some = Optional.of("Deepanshu");
        some.stream().forEach(System.out::println);
    }
}
