package com.book.consumeapi.error;

import com.book.consumeapi.controller.getbookcontroller.GetBookControllerImpl;
import com.book.consumeapi.model.errormodel.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ErrorSolver {

    private Logger log = LoggerFactory.getLogger(GetBookControllerImpl.class);

    @ExceptionHandler(HttpClientErrorException.class)
    public ErrorResponse handleHttpClientErrorException(HttpClientErrorException exception,
                                                        HttpServletResponse servletResponse) {

        ErrorResponse response = new ErrorResponse();
        response.setErrorDescription("Book Id does not exist");
        servletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        log.info("Error HttpClientErrorException found");
        log.warn("Error has been found returning status: " + HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        return response;
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ErrorResponse handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception,
                                                                   HttpServletResponse servletResponse) {

        ErrorResponse response = new ErrorResponse();
        response.setErrorDescription("Input must be an integer");
        servletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        log.info("Error MethodArgumentTypeMismatchException found");
        log.warn("Error has been found returning status: " + HttpServletResponse.SC_BAD_REQUEST);

        return response;
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ErrorResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception,
                                                                      HttpServletResponse servletResponse) {

        ErrorResponse response = new ErrorResponse();
        response.setErrorDescription("Method not allowed");
        servletResponse.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);

        log.info("Error HttpRequestMethodNotSupportedException found");
        log.warn("Error has been found returning status: " + HttpServletResponse.SC_METHOD_NOT_ALLOWED);

        return response;
    }
}
