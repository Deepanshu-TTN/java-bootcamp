package com.ttn.restful.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private static List<User> users = new ArrayList<>();
    private static Integer userCount;

    static {
        users.add(new User(1, "Talha", "password1", "apple"));
        users.add(new User(2, "Anjani", "password2", "date"));
        users.add(new User(3, "Punam", "password3", "lichi"));
        users.add(new User(4, "Phalki", "password4", "orange"));
        userCount = 4;
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Optional<User> user = users.stream().filter(e->e.getId() == id).findFirst();
        return user.orElseThrow(()->new RuntimeException("User not found"));
    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        System.out.println(user);
        return user;
    }

    public void delete(Integer id) {
        users.removeIf(e->e.getId().equals(id));
    }

    public MappingJacksonValue getUserIdAndFavoriteFruit(int id){
        UserDynamic userDynamic = new UserDynamic(findOne(id));
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.
                filterOutAllExcept("favoriteFruit", "id");

        FilterProvider provider = new SimpleFilterProvider().addFilter("DynamicFilter", filter);

        MappingJacksonValue value = new MappingJacksonValue(userDynamic);

        value.setFilters(provider);

        return value;
    }

}
