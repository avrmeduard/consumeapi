package com.book.consumeapi.controller.deletebookcontroller;

import com.book.consumeapi.model.errormodel.ErrorResponse;
import com.book.consumeapi.model.getbook.GetBookResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Api(value = "rest-getBook",
     description = "Consumer API for book")
public interface DeleteBookController {


    @ApiOperation(value = "Delete all books", nickname = "rest-deleteBook")
    @ApiResponses(value = {@ApiResponse(code = HttpServletResponse.SC_OK,
                                        message = "Result matching criteria",
                                        response = GetBookResponse.class),

                           @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND,
                                        message = "No books found",
                                        response = GetBookResponse.class),

                           @ApiResponse(code = HttpServletResponse.SC_METHOD_NOT_ALLOWED,
                                        message = "Method not allowed",
                                        response = ErrorResponse.class) })
    @DeleteMapping("/rest-deleteBook")
    ResponseEntity<?> deleteBooks();


    @ApiOperation(value = "Delete book", nickname = "rest-deleteBookId")
    @ApiResponses(value = {@ApiResponse(code = HttpServletResponse.SC_OK,
                                        message = "Result matching criteria",
                                        response = GetBookResponse.class),

                           @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND,
                                        message = "No entry found",
                                        response = ErrorResponse.class),

                           @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST,
                                        message = "Invalid request",
                                        response = GetBookResponse.class),

                           @ApiResponse(code = HttpServletResponse.SC_METHOD_NOT_ALLOWED,
                                        message = "Method not allowed",
                                        response = ErrorResponse.class) })
    @DeleteMapping("/rest-deleteBook/")
    ResponseEntity<?> deleteBookbyId(@RequestParam Optional<Integer> bookId);
}

