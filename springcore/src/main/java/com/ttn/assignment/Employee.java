package com.ttn.assignment;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    String name = "Deepanshu";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
