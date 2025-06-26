package assignment;

interface InterOne {
    default void sayHello(){
        System.out.println("Hello from interface one!");
    }
}

interface InterTwo {
    default void sayHello(){
        System.out.println("Hello from interface two!");
    }
}

public class Question3 implements InterOne, InterTwo{
    @Override
    public void sayHello() {
        // using one of the interfaces
        InterOne.super.sayHello();
        InterTwo.super.sayHello();

        // own logic
        System.out.println("hello from ques3!");
    }

    public static void main(String[] args) {
        Question3 q = new Question3();
        q.sayHello();
//        no bueno
//        InterTwo.super.sayHello();
    }
}
