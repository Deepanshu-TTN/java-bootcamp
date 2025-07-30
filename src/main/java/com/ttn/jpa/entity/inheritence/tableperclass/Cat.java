package com.ttn.jpa.entity.inheritence.tableperclass;

import jakarta.persistence.Entity;

@Entity
public class Cat extends Animal {
    private Boolean likesCatnip;

    public boolean isLikesCatnip() {
        return likesCatnip;
    }

    public void setLikesCatnip(boolean likesCatnip) {
        this.likesCatnip = likesCatnip;
    }
}
