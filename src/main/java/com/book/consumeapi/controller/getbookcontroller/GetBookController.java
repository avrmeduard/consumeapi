package com.book.consumeapi.controller.getbookcontroller;

import com.book.consumeapi.model.bookmodel.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

public interface GetBookController {

    @GetMapping("/rest-getBook")
    ResponseEntity<?> getBookSummary(@RequestParam Optional<Integer> bookId);
}

