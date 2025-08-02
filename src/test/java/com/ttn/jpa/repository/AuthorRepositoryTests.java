package com.ttn.jpa.repository;

import com.ttn.jpa.entities.Address;
import com.ttn.jpa.entities.Author;
import com.ttn.jpa.entities.Book;
import com.ttn.jpa.entities.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

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

    @Test
    @Transactional
    @Rollback(value = false)
    public void testPersistSubjects() {
        Author author1 = new Author();
        author1.setName("New Author 1");

        Author author2 = new Author();
        author2.setName("New Author 2");

        for( Author author : List.of(author1, author2)){
            Subject mafs = new Subject("Maths");
            Subject francais = new Subject("French");
            Subject english = new Subject("English");
            author.addSubjects(mafs, francais, english);
        }
        repository.saveAll(List.of(author1, author2));
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testSaveBooks() {
        List<Author> authors = repository.findAll();
        List<Book> books = IntStream.range(1,10)
                .mapToObj(i->{
                    Book book = new Book();
                    book.setBookName("Book "+i);
                    return book;
                }).toList();

        authors.getFirst().addBooks(books.subList(0,3).toArray(Book[]::new));
        authors.get(1).addBooks(books.subList(3,6).toArray(Book[]::new));
        authors.get(2).addBooks(books.subList(6,9).toArray(Book[]::new));

        repository.saveAll(authors);
    }
}
