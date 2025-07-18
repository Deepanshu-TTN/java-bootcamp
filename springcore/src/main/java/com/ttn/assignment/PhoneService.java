package com.ttn.assignment;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PhoneService implements NotifierService {
    public void notifyUser(String message) {
        System.out.println("User notified via phone!\nMessage: " + message);
    }
}
