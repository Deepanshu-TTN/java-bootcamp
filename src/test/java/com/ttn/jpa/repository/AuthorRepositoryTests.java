package com.ttn.jpa.repository;

import com.ttn.jpa.entities.Address;
import com.ttn.jpa.entities.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthorRepositoryTests {
    @Autowired
    AuthorRepository repository;

    @Test
    public void testCreateEmbeddedEntity(){
        Address address = new Address();
        address.setLocation("Shakarpur");
        address.setState("Delhi");
        address.setStreetNumber("Extn road 1");

        Author author = new Author();
        author.setName("Chetan");
        author.setAddress(address);
        repository.save(author);
    }
}
