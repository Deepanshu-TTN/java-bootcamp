//public class Question8 {
//    public static void main(String[] args) {
//        SomeClass s = new SomeClass();
//        s.sayHello();
//    }
//}

public class Question8 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("SomeClass");
    }
}

//class SomeClass {
//    public void sayHello() {
//        System.out.println("Hello from Some CLass!");
//    }
//}