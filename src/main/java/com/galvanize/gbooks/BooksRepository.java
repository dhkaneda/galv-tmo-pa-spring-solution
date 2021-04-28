package com.galvanize.gbooks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthorContainsAndTitleContains(String author, String title);
    List<Book> findBooksByDatePublishedAfter(Date rel);
}
