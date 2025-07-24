package com.ttn.restful.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

    // MIME-TYPE VERSIONING
    @GetMapping(value = "/users/{id}/fav-fruit", produces = "application/vnd.company.app-v2+json")
    public MappingJacksonValue getUserFavoriteFruitMime(@PathVariable("id") Integer id) {
        return userService.getUserIdAndFavoriteFruit(id);
    }

    // Request Parameter Versioning
    @GetMapping(value = "/users/{id}/fav-fruit", params = "version=2")
    public MappingJacksonValue getUserFavoriteFruitParam(@PathVariable("id") Integer id) {
        return userService.getUserIdAndFavoriteFruit(id);
    }

    // URI versioning
    @GetMapping("/v2/users/{id}/fav-fruit")
    public MappingJacksonValue getUserFavoriteFruitURI(@PathVariable("id") Integer id) {
        return userService.getUserIdAndFavoriteFruit(id);
    }

    // Header Versioning
    @GetMapping(value = "/users/{id}/fav-fruit", headers = "X-API-VERSION=2")
    public MappingJacksonValue getUserFavoriteFruitHeader(@PathVariable("id") Integer id) {
        return userService.getUserIdAndFavoriteFruit(id);
    }

    @GetMapping("/users/{id}/hateoas")
    public EntityModel<User> getUserWithHyperlinks(@PathVariable("id") int id){
        EntityModel<User> userEntityModel = EntityModel.of(userService.findOne(id));
        Link link = linkTo(methodOn(this.getClass()).getAllUsers()).withRel("all-users");
        userEntityModel.add(link);
        return userEntityModel;
    }

}
