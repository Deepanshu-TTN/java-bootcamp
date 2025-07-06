package assignment;

import java.util.Objects;

public class Question1 {
    public static void main(String[] args) {
        Student s1 = new Student("S1", "Deepanshu", 11);
        System.out.println(s1);
    }
}

record Student(String id, String name, int standard){}