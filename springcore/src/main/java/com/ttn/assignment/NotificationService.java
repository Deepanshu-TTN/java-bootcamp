package com.ttn.assignment;

/*
// Tightly coupled
public class NotificationService {
//    EmailService emailService = new EmailService();
    PhoneService phoneService = new PhoneService();

    public void send(String message){
        String finalMessage = "Some Title\n" + message;
//        emailService.notifyUser(finalMessage);
        phoneService.notifyUser(finalMessage);

    }
}
*/

/*
// Loosely coupled
public class NotificationService {
    NotifierService notifierService;

    public NotificationService(NotifierService notifierService){
        this.notifierService = notifierService;
    }

    public void send(String message){
        String finalMessage = "Some Title\n" + message;
        notifierService.notifyUser(message);
    }
}
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


/*
// Loosely coupled using spring without ambiguity
@Component
public class NotificationService {

    @Autowired
    @Qualifier("emailService")
    NotifierService notifierService;

    public void send(String message){
        String finalMessage = "Some Title\n" + message;
        notifierService.notifyUser(message);
    }
}
 */


// Constructor injection
@Component
public class NotificationService {

    NotifierService notifierService;

    @Autowired
    public NotificationService(NotifierService notifierService) {
        this.notifierService = notifierService;
    }

    public void send(String message){
        String finalMessage = "Some Title\n" + message;
        notifierService.notifyUser(message);
    }
}