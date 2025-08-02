package com.ttn.jpa.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST)
    private List<Subject> subjects;
/* one to one author-book
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
 */

/* One to many unidirectional
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "author_id")
    private List<Book> books;

    public void addBooks(Book ... books){
        if(this.books == null){
            setSubjects(new ArrayList<>());
        }
        this.books.addAll(List.of(books));
    }
 */
/*
    @OneToMany(mappedBy = "author", cascade = CascadeType.MERGE)
    private List<Book> books;

    public void addBooks(Book... books) {
        if(this.books == null){
            setSubjects(new ArrayList<>());
        }
        this.books.addAll(List.of(books));
        Arrays.stream(books).forEach(
                b->b.setAuthor(this)
        );
    }
*/
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addSubjects(Subject ... subjects){
        if(this.subjects == null){
            setSubjects(new ArrayList<>());
        }
        this.subjects.addAll(List.of(subjects));
        Arrays.stream(subjects).forEach(
                s -> s.setAuthor(this));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
