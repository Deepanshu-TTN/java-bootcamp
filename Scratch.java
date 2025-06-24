// Integer class is immutable due to final attribute 'value'.
// Even though it seems like we are passing a reference of Integer object which we are
// anytime we change the object, a new object is always created since we're changing
// the value attribute.
/*
public class Scratch{
    public static void main(String[] args) {
        Integer i = 5;
        increment(i);
        System.out.println(i);
    }

    static void increment(Integer i){
        Integer a = i ++;
        Integer b = a;
        b++;
        System.out.println(a==b);
    }
}
*/