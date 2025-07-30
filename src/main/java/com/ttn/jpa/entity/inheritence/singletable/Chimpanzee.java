package com.ttn.jpa.entity.inheritence.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("chimp")
public class Chimpanzee extends Monkey{
    private String toolUsage;

    public String getToolUsage() {
        return toolUsage;
    }

    public void setToolUsage(String toolUsage) {
        this.toolUsage = toolUsage;
    }
}
