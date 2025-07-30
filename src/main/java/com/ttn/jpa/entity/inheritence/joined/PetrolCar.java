package com.ttn.jpa.entity.inheritence.joined;

import jakarta.persistence.Entity;

@Entity
public class PetrolCar extends Car{
    private String tankCapacity;

    public String getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(String tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
}
