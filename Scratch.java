//interface Animal{
//    void speak();
//}

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public class Scratch {
    private int a;
    public static void main(String[] args) {
//        Animal cat = ()-> System.out.println("mew");
//        cat.speak();
//        SomeClass s1 = new SomeClass(1);
//        SomeClass s2 = new SomeClass(2);
//
//        map.put(s2, false);
//        map.put(s1, true);
//        System.out.println(map.get(new SomeClass(1)));

        SomeClass s = new SomeClass(1);
        Map<SomeClass, Boolean> map = new HashMap<>();
        map.put(s, true);
        s.id = 2;
        System.out.println(map.get(s));

    }
}

class SomeClass {
    public int id;
    SomeClass(int i){id=i;}
//    @Override
//    public boolean equals(Object obj) {
//        System.out.println("equl called");
//        return false;
//    }
//
//    @Override
//    public int hashCode() {
//        System.out.println("has called");
//        return 1;
//    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SomeClass someClass = (SomeClass) o;
        return id == someClass.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}