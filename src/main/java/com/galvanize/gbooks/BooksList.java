package com.galvanize.gbooks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class BooksList {
    private List<Book> books;

    public BooksList() {
    }

    @JsonIgnore
    public boolean isEmpty() {
        return books == null || this.books.isEmpty();
    }

    public BooksList(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
