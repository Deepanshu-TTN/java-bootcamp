package com.ttn.jpa.entity.inheritence.tableperclass;

import jakarta.persistence.Entity;

@Entity
public class Dog extends Animal{
    private String trainedLevel;

    public String getTrainedLevel() {
        return trainedLevel;
    }

    public void setTrainedLevel(String trainedLevel) {
        this.trainedLevel = trainedLevel;
    }
}
