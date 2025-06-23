/** Write a class with FirstName, LastName & age field. Print Firstname, LastName & age
 * using static block, static method & static variable respectively. */
public class Question1 {
    public static void main(String[] args) {
        Person.detail();

        System.out.println("Print Statement from Static Attributes");
        System.out.println(Person.firstName + " " + Person.lastName + ", " + Person.age + "\n");
    }
}

class Person {
    static String firstName = "Chinto";
    static String lastName = "Chib";
    static byte age = 21;

    static {
        System.out.println("Print Statement from Static block");
        System.out.println(firstName + " " + lastName + ", " + age + "\n");
    }

    public static void detail() {
        System.out.println("Print Statement from Static method");
        System.out.println(firstName + " " + lastName + ", " + age + "\n");
    }
}