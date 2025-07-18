package com.ttn.assignment;

import org.springframework.stereotype.Service;

@Service
public class EmailService implements NotifierService {
    public void notifyUser(String message) {
        System.out.println("User notified via email!\nMessage: " + message);
    }
}
