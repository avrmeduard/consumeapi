package com.book.consumeapi.controller.getbookcontroller;

import com.book.consumeapi.model.bookmodel.Book;
import com.book.consumeapi.model.errormodel.ErrorResponse;
import com.book.consumeapi.model.getbook.GetBookResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Optional;

@Api(value = "rest-getBook",
     description = "Consumer API for book")
public interface GetBookController {


    /**
     *
     * Get all books
     *
     */
    @ApiOperation(value = "Get all books", nickname = "rest-getBook")
    @ApiResponses(value = {@ApiResponse(code = HttpServletResponse.SC_OK,
                                        message = "Result matching criteria",
                                        response = GetBookResponse.class),

                           @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND,
                                        message = "Invalid request",
                                        response = GetBookResponse.class),

                           @ApiResponse(code = HttpServletResponse.SC_METHOD_NOT_ALLOWED,
                                        message = "Method not allowed",
                                        response = ErrorResponse.class) })
    @GetMapping("/rest-getBook")
    ResponseEntity<?> getBook();


    /**
     *
     * Get book by id
     *
     */
    @ApiOperation(value = "Get book", nickname = "rest-getBookId")
    @ApiResponses(value = {@ApiResponse(code = HttpServletResponse.SC_OK,
                                        message = "Result matching criteria",
                                        response = GetBookResponse.class),

                           @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND,
                                        message = "Book Id does not exist",
                                        response = ErrorResponse.class),

                           @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST,
                                        message = "Invalid request",
                                        response = GetBookResponse.class),

                           @ApiResponse(code = HttpServletResponse.SC_METHOD_NOT_ALLOWED,
                                        message = "Method not allowed",
                                        response = ErrorResponse.class) })
    @GetMapping("/rest-getBook/")
    ResponseEntity<?> getBookById(@RequestParam Optional<Integer> bookId);
}

