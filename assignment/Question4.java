package assignment;

import java.util.Optional;

public class Question4 {
    public static void main(String[] args) {
            // Optional.of() and Optional.empty()
            Optional<String> optionalWithValue = Optional.of("Hello Optional!");
            Optional<String> emptyOptional = Optional.empty();

            // isPresent()
            System.out.println("optionalWithValue is present? " + optionalWithValue.isPresent());
            System.out.println("emptyOptional is present? " + emptyOptional.isPresent());

            // ifPresent()
            optionalWithValue.ifPresent(value -> System.out.println("Value with ifPresent: " + value));
            emptyOptional.ifPresent(value -> System.out.println("This will not be printed"));

            // orElse()
            String result1 = optionalWithValue.orElse("Default Value");
            String result2 = emptyOptional.orElse("Default Value");
            System.out.println("Result with orElse: " + result1);
            System.out.println("Result with orElse (empty): " + result2);

            // orElseGet()
            String result3 = emptyOptional.orElseGet(() -> "Generated Default");
            System.out.println("Result with orElseGet: " + result3);

            // orElseThrow()
            try {
                String result4 = emptyOptional.orElseThrow(() -> new RuntimeException("Value not present!"));
            } catch (RuntimeException e) {
                System.out.println("Caught exception from orElseThrow: " + e.getMessage());
            }

            // ifPresentOrElse()
            optionalWithValue.ifPresentOrElse(
                    value -> System.out.println("Value with ifPresentOrElse: " + value),
                    () -> System.out.println("Value not present in ifPresentOrElse")
            );

            emptyOptional.ifPresentOrElse(
                    value -> System.out.println("This will not be printed"),
                    () -> System.out.println("Empty optional handled in ifPresentOrElse")
            );

            // map() and filter()
            Optional<Integer> lengthOptional = optionalWithValue.map(String::length);
            lengthOptional.ifPresent(length -> System.out.println("Length of string: " + length));

            Optional<String> longStringOptional = optionalWithValue.filter(s -> s.length() > 10);
            longStringOptional.ifPresent(s -> System.out.println("Filtered value: " + s));

            Optional<String> shortStringOptional = optionalWithValue.filter(s -> s.length() < 5);
            System.out.println("Short string optional is present? " + shortStringOptional.isPresent());

        }
}
