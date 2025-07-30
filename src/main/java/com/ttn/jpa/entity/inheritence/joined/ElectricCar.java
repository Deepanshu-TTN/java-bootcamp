package com.ttn.jpa.entity.inheritence.joined;

import jakarta.persistence.Entity;

@Entity
public class ElectricCar extends Car{
    private String batteryCapacity;

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }
}
