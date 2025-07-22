package com.ttn.restful.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
    private Integer id;
    private String username;

    @JsonIgnore
    private String password;
    private String favoriteFruit;

    public User(Integer id, String username, String password, String favoriteFruit) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.favoriteFruit = favoriteFruit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFavoriteFruit() {
        return favoriteFruit;
    }

    public void setFavoriteFruit(String favoriteFruit) {
        this.favoriteFruit = favoriteFruit;
    }
}
