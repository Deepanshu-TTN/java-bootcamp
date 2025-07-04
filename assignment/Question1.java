package assignment;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Question1 {

    public static void main(String[] args) {
        // implementing consumer
        Consumer<String> printUpper = s-> System.out.println(s.toUpperCase());
        printUpper.accept("hello hello");

        // implementing supplier
        Supplier<Double> randomPercentage = ()->Math.random() * 100;
        System.out.println(randomPercentage.get());

        // implementing predicate
        Predicate<Integer> divByThree = n -> n % 3 == 0;
        System.out.println(divByThree.test(39));

        // implementing function
        Function<String, Integer> countVowels = word -> {
            int count = 0;
            String vowels = "aeiouAEIOU";
            for (char c : word.toCharArray()) {
                if (vowels.indexOf(c) != -1) {
                    count++;
                }
            }
            return count;
        };
        System.out.println(countVowels.apply("DeepanshU"));
    }
}
