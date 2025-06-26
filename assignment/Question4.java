package assignment;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

class SomeClass {
    int a; int b;

    public SomeClass() {
        this.a = 0; this.b = 0;
    }
    public SomeClass(int a) {
        this.a = a; this.b = 0;
    }
    public SomeClass(int a, int b) {
        this.a = a; this.b = b;
    }

    void display() {
        System.out.println("Values of a and b are: " + a + ", " + b);
    }
}

public class Question4 {
    public static void main(String[] args) {
        Supplier<SomeClass> defaultSupplier = SomeClass::new;
        defaultSupplier.get().display();

        Function<Integer,SomeClass> oneArgSupplier = SomeClass::new;
        oneArgSupplier.apply(20).display();

        BiFunction<Integer, Integer, SomeClass> twoArgSupplier = SomeClass::new;
        twoArgSupplier.apply(30, 50).display();
    }
}
