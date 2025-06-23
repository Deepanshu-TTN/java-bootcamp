package FactoryPattern;

public class Main {

}

class User {
    private String _username;
    private String _id;

    public void set_id(String id) {
        _id = id;
    }

    public void set_username(String username) {
        _username = username;
    }
}

class AdminUser extends User {
    private final String _role = "admin";
}

class ModeratorUser extends User {
    private final String _role = "moderator";
}

class NormalUser extends User {
    private final String _role = "user";
}