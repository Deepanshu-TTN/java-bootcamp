package assignment;

import java.util.ArrayList;
import java.util.List;

public class Question6 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.addFirst(10);
        list.addLast(30);

        System.out.println(list);

        System.out.println("last: " + list.getLast());
        System.out.println("first: " + list.getFirst());

        System.out.println("removed(first): " + list.removeFirst());

        list.add(40); list.add(50);
        System.out.println("list: " + list);
        System.out.println("reversed: " + list.reversed());
    }
}
