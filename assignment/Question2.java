package assignment;

import java.io.*;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        String choice;
        try (Scanner scanner = new Scanner(System.in);
             FileOutputStream fout = new FileOutputStream("./assignment/user.txt", true);
             ObjectOutputStream out = new ObjectOutputStream(fout)){

            do {
                System.out.println("Enter first name, last name, age and phone number");

                String fistName = scanner.next();
                String lastName = scanner.next();
                byte age = scanner.nextByte();
                String phoneNumber = scanner.next();

                User user = new User(fistName, lastName, age, phoneNumber);
                out.writeObject(user);

                System.out.println("Do you want to continue creating users? (Type QUIT to exit)");
                choice = scanner.next();
            } while (!choice.equals("QUIT"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

class User implements Serializable {
    String firstNamr;
    String lastName;
    byte age;
    String phoneNumber;

    public User(String firstname, String lastname, byte age, String phoneNumber) {
        this.firstNamr = firstname;
        this.lastName = lastname;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return firstNamr + " " + lastName + ", Age: " + age + ", Phone: " + phoneNumber;
    }
}
