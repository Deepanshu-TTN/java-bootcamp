package assignment;

import java.util.Scanner;

public class Question4 {
    static void notificationWithoutFactory() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Notification notification;

        switch (input.toLowerCase()) {
            case "email":
                notification = new EmailNotification();
                break;
            case "sms":
                notification = new SMSNotification();
                break;
            case "push":
                notification = new PushNotification();
                break;
            default:
                notification = new Notification();
        }
        notification.send();
    }

    static void notificationWithFactory() {
        Notification notification = NotificationFactory.getNotification("email");
        notification.send();
    }

    public static void main(String[] args) {
        System.out.println("Without Factory:");
        notificationWithoutFactory();
        System.out.println("\nWith Factory:");
        notificationWithFactory();
    }
}

class NotificationFactory {
    static Notification getNotification(String type) {
        switch (type) {
            case "email":
                return new EmailNotification();
            case "sms":
                return new SMSNotification();
            case "push":
                return new PushNotification();
            default:
                return new Notification();
        }
    }
}

class Notification {
    public void send(){
        System.out.println("Not Implemented");
    };
}

class EmailNotification extends Notification {
    @Override
    public void send() {
        System.out.println("Sending Email Notification");
    }
}

class SMSNotification extends Notification {
    @Override
    public void send() {
        System.out.println("Sending SMS Notification");
    }
}

class PushNotification extends Notification {
    @Override
    public void send() {
        System.out.println("Sending Push Notification");
    }
}
