interface Animal{
    void speak();
}

public class Scratch {
    public static void main(String[] args) {
        Animal cat = ()-> System.out.println("mew");
        cat.speak();
    }
}