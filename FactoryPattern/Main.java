package FactoryPattern;

import java.util.Scanner;

public class Main {
    static void userMockWithoutFactory() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        User user;
        switch (input){
            case "admin":
                user = new AdminUser("1", "Deepanshu");
                break;
            case "moderator":
                user = new ModeratorUser("1", "Deepanshu");
                break;
            case "normal":
                user = new NormalUser("1", "Deepanshu");
                break;
            default: user = new User("1", "Deepanshu");
        }
        System.out.println(user);
    }

    static void userMockWithFactory() {
        User user = UserFactory.getUser("admin", "Deepanshu", "1");
        System.out.println(user);
    }

    public static void main(String[] args) {
        userMockWithoutFactory();
        userMockWithFactory();
    }
}

class User {
    private String _username;
    private String _id;

    User(String id,String username){
        set_id(id);set_username(username);
    }

    public void set_id(String id) {
        _id = id;
    }

    public void set_username(String username) {
        _username = username;
    }

    @Override
    public String toString() {
        return _id + ": " + _username;
    }
}

class UserFactory {
    private static User user;

    static User getUser(String role, String username, String id) {
        switch (role){
            case "admin":
                user = new AdminUser(id, username);
                break;
            case "moderator":
                user = new ModeratorUser(id, username);
                break;
            case "normal":
                user = new NormalUser(id, username);
                break;
        }
        return user;
    }
}

class AdminUser extends User {
    private final String _role;

    AdminUser(String id, String username){
        super(id, username);
        _role = "admin";
    }

    @Override
    public String toString() {
        return "AdminUser " + super.toString() + _role;
    }
}

class ModeratorUser extends User {
    private final String _role;

    ModeratorUser(String id, String username){
        super(id, username);
        _role  = "moderator";
    }
    @Override
    public String toString() {
        return "Moderator " + super.toString() + _role;
    }
}

class NormalUser extends User {
    private final String _role;

    NormalUser(String id, String username){
        super(id, username);
        _role = "user";
    }

    @Override
    public String toString() {
        return "NormalUser " + super.toString() + _role;
    }
}