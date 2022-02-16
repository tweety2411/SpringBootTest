package com.heypli.springboottest.app.book.service.impl;

import com.heypli.springboottest.app.book.model.Book;
import com.heypli.springboottest.app.book.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public List<Book> getBookList() {
        return null;
    }
}
