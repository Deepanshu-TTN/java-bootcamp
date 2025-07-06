package assignment;

public class Question4 {
    public static void main(String[] args) {
        Animal tomtom = new Dog();
        Animal pinky = new Cat();
        Animal pablo = new Bird();
        tomtom.makeSound();pinky.makeSound();pablo.makeSound();;
    }
}

sealed class Animal permits Mammal, Bird {
    void makeSound() {
        System.out.println("animal sound");
    }
}

sealed class Mammal extends Animal permits Dog, Cat { }

non-sealed class Bird extends Animal {
    @Override
    void makeSound() {
        System.out.println("kooooooo");
    }
}

final class Dog extends Mammal {
    @Override
    void makeSound() {
        System.out.println("bhau");
    }
}

final class Cat extends Mammal {
    @Override
    void makeSound() {
        System.out.println("mau");
    }
}