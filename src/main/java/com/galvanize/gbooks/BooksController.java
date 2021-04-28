package com.galvanize.gbooks;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class BooksController {

    BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/api/books")
    public Book postBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/api/books")
    public ResponseEntity<BooksList> getBooks(@RequestParam(defaultValue = "") String author,
                                              @RequestParam(defaultValue = "") String title) {
        BooksList booksList = bookService.searchBooks(author, title);
        return ResponseEntity.ok(booksList);
    }

    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        Book book = bookService.getBook(id);
        if(book != null){
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        Book book = bookService.getBook(id);
        if(book != null){
            bookService.deleteBook(id);
            return ResponseEntity.ok(String.format("Book with id %s deleted", id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/books")
    public ResponseEntity<String> deleteAllBooks(){
        bookService.deleteAllBooks();
        return ResponseEntity.ok(String.format("All Books deleted."));
    }
}
