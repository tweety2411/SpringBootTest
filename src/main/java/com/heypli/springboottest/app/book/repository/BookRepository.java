package com.heypli.springboottest.app.book.repository;

import com.heypli.springboottest.app.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Book, Integer> {

}
