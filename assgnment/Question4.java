package assgnment;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Question4 {
    public static void main(String[] args) {
        List<String> listProduced = Stream.of("delhi", "mumbai", "kolkata")
                .toList();
//              .collect(Collectors.toUnmodifiableList()); // same result

        try {
            System.out.println("list before: " + listProduced);
            listProduced.add("pudducherry");
        } catch (UnsupportedOperationException _) {
            System.out.println("Hence proved list unmodifiable");
            System.out.println("list after : " + listProduced);
        }
    }
}
