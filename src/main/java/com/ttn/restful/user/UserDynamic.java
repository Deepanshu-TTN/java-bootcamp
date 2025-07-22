package com.ttn.restful.user;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("DynamicFilter")
public class UserDynamic extends User{

    public UserDynamic(Integer id, String username, String password, String favoriteFruit) {
        super(id, username, password, favoriteFruit);
    }
    public UserDynamic(User user) {
        super(user.getId(), user.getUsername(), user.getPassword(), user.getFavoriteFruit());
    }
}
