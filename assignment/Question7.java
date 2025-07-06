package assignment;

import java.util.LinkedHashMap;
import java.util.SequencedMap;

public class Question7 {
    public static void main(String[] args) {
        SequencedMap<String, Integer> seqMap = new LinkedHashMap<>();

        seqMap.put("B", 2);

        seqMap.putFirst("A", 1);
        seqMap.putLast("C", 3);

        System.out.println(seqMap);
        System.out.println("First Entry: " + seqMap.firstEntry());
        System.out.println("Last Entry: " + seqMap.lastEntry());

        System.out.println("polled (first): " + seqMap.pollFirstEntry());
        System.out.println("polled (last): " + seqMap.pollLastEntry());

        System.out.println("After Polling: " + seqMap);

        seqMap.putFirst("X", 10);
        seqMap.putLast("Z", 99);

        System.out.println("map" + seqMap);
        System.out.println("reversed" + seqMap.reversed());
    }
}
