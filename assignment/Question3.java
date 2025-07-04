package assignment;

import java.util.Arrays;
import java.util.List;

public class Question3 {
    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(3,2,12,67,1,5,8,10);
        int sumGreaterThan5 = numList.stream().filter(e-> e > 5).reduce(0, Integer::sum);
        System.out.println("Sum of nums greater than 5 in" + numList + ": "+ sumGreaterThan5);
    }
}
