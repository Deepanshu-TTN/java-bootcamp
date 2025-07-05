package assgnment;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Question3 {
    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana", "cherry");
        Set<String> set = Set.of("apple", "banana", "cherry");
        Map<String, String> map = Map.of("apple", "red", "banana", "yellow", "cherry", "red");
        System.out.println(list);
        System.out.println(set);
        System.out.println(map);
    }
}
