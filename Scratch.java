class Parent {
    protected void display() {
        System.out.println("Parent display");
    }

    public void getDisplay() {
        display();
    }
}

class Child extends Parent {
     protected void display() {
        System.out.println("Child display");
    }
}

public class Scratch {
    public static void main(String[] args) {
        Parent c = new Child();
        c.getDisplay();
    }
}