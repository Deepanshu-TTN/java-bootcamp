//interface Animal{
//    void speak();
//}

import java.util.HashMap;
import java.util.Map;

public class Scratch {
    private int a;
    public static void main(String[] args) {
//        Animal cat = ()-> System.out.println("mew");
//        cat.speak();
        SomeClass s1 = new SomeClass(1);
        SomeClass s2 = new SomeClass(2);
        Map<SomeClass, Boolean> map = new HashMap<>();
        map.put(s2, false);
        map.put(s1, true);
        System.out.println(map.get(new SomeClass(1)));
    }
}

class SomeClass {
    public int id;
    SomeClass(int i){id=i;}
    @Override
    public boolean equals(Object obj) {
        System.out.println("equl called");
        return false;
    }

    @Override
    public int hashCode() {
        System.out.println("has called");
        return 1;
    }

}