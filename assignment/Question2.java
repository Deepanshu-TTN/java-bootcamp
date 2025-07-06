package assignment;

import java.util.Objects;

public class Question2 {
    public static void main(String[] args) {
        Studentt s = new Studentt(null, null, 12);
    }
}

record Studentt(String id, String name, int standard){
    Studentt {
        Objects.requireNonNull(id, "Id cant be empty");
        Objects.requireNonNull(name, "NO NAME????");
    }
}