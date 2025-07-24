package com.ttn.restful.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private Integer id;
    private String username;

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFavoriteFruit() {
        return favoriteFruit;
    }

    public void setFavoriteFruit(String favoriteFruit) {
        this.favoriteFruit = favoriteFruit;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", favoriteFruit='" + favoriteFruit + '\'' +
                '}';
    }
}
