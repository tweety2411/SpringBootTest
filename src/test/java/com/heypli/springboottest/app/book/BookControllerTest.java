package com.heypli.springboottest.app.book;

import com.heypli.springboottest.app.book.controller.BookController;
import com.heypli.springboottest.app.book.model.Book;
import com.heypli.springboottest.app.book.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.hamcrest.Matchers.contains;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    // BookService를 목 빈으로 만들어서 사용하겠다는 뜻
    @MockBean
    private BookService bookService;

    @Test
    public void book_mvc_test() throws Exception {
        Book book = new Book("test북", LocalDateTime.now());

        // bookService.getBookList를 호출했을 때 리턴할 값 세팅
        given(bookService.getBookList()).willReturn(Collections.singletonList(book));
        mvc.perform(MockMvcRequestBuilders.get("/books")) // GET  메소드 호출
                .andExpect(status().isOk()) // 리턴값체크
                .andExpect(view().name("book")) // 리턴뷰 체크
                .andExpect(model().attributeExists("bookList")) // 리턴 attribute체크
                .andExpect(model().attribute("bookList", contains(book))); // 리턴리스트 체크
    }

}
