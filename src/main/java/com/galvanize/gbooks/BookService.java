package com.galvanize.gbooks;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    BooksRepository booksRepository;

    public BookService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Book addBook(Book book) {
        return booksRepository.save(book);
    }

    public BooksList searchBooks(String author, String title) {
        if(author.equals("") && title.equals("")) {
            return new BooksList(booksRepository.findAll());
        } else {
            return new BooksList(booksRepository.findAllByAuthorContainsAndTitleContains(author, title));
        }
    }

    public Book getBook(long id) {
        Optional<Book> optionalBook = booksRepository.findById(id);
        return optionalBook.orElse(null);
    }

    public void deleteBook(long id) {
        booksRepository.deleteById(id);
    }

    public void deleteAllBooks() {
        booksRepository.deleteAll();
    }
}
