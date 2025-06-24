package assignment;

public class Question1 {

    public static void main(String[] args) {
        for(House h : House.values()) {
            System.out.println(h.getValue() +"lakh "+ h);
        }
    }
}

enum House {
    ONE_BHK(80), TWO_BHK(90), THREE_BHK(100);

    private final int price;

    House(int value) {
        System.out.println("Setting " + this + " value: " + this.getValue());
        this.price = value;
        System.out.println("After setting " + this + " value: " + this.getValue());
    }

    public int getValue() {
        return price;
    }
}