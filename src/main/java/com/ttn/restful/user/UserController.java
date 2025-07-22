package com.ttn.restful.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "User Controller", description = "User management like fetching, saving, and deleting users.")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    @Operation(summary = "Create new User", description = "Saves details of a new user with auto generated Id")
    public User createUser(@RequestBody User user){
        return userService.save(user);
    }
    @GetMapping("/users")
    @Operation(summary = "Get all users", description = "List all user objects")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    @Operation(summary = "Get a user by id", description = "Fetch details of a user by it's id")
    public User getUser(@PathVariable Integer id){
        return userService.findOne(id);
    }

    @DeleteMapping("/users/{id}")
    @Operation(summary = "Delete User", description = "Delete a user by it's Id")
    public void deleteUser(@PathVariable Integer id){
        userService.delete(id);
    }

    @GetMapping("/users/{id}/fav-fruit")
    public MappingJacksonValue getUserFavoriteFruit(@PathVariable("id") Integer id){
        UserDynamic userDynamic = new UserDynamic(userService.findOne(id));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.
                filterOutAllExcept("favoriteFruit", "username");

        FilterProvider provider = new SimpleFilterProvider().addFilter("DynamicFilter", filter);

        MappingJacksonValue value = new MappingJacksonValue(userDynamic);

        value.setFilters(provider);

        return value;
    }
}
