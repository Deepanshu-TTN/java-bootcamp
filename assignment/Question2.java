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
    String _firstName;
    String _lastName;
    byte _age;
    String _phoneNumber;

    public User(String firstname, String lastname, byte age, String phoneNumber) {
        _firstName = firstname;
        _lastName = lastname;
        _age = age;
        _phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return _firstName + " " + _lastName + ", Age: " + _age + ", Phone: " + _phoneNumber;
    }
}
