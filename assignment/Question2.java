package assignment;

interface MyInterface {
    default void defMethod(){
        System.out.println("Default method yohoo");
    }

    static void statMethod(){
        System.out.println("Static method yohoo");
    }
}

public class Question2 implements MyInterface {
    public static void main(String[] args) {
        MyInterface.statMethod();
        new Question2().defMethod();
    }
}
