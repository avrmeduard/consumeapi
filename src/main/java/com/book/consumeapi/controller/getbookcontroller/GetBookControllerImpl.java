package com.book.consumeapi.controller.getbookcontroller;

import com.book.consumeapi.model.bookmodel.Book;
import com.book.consumeapi.model.getbook.GetBook;
import com.book.consumeapi.model.getbook.GetBookResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@RestController
public class GetBookControllerImpl implements GetBookController{

    @Value("${mvc.basepath}")
    private String basePath;

    @Value("${mvc.getendpoint}")
    private String getEndPoint;

    @Autowired
    private ObjectMapper objectMapper;

    private RestTemplate restTemplate = new RestTemplate();


    @Override
    public ResponseEntity<?> getBookSummary(Optional<Integer> bookId) {

        if (bookId.isPresent()) {

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(httpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            httpHeaders.add(httpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

            HttpEntity httpEntity = new HttpEntity(httpHeaders);

            ResponseEntity<String> responseEntity = restTemplate.exchange(basePath+getEndPoint+"?bookId={id}",
                                                               HttpMethod.GET,
                                                               httpEntity,
                                                               String.class,
                                                               bookId.get() );

            System.out.println(responseEntity.getBody());

            if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {


                try {

                    GetBookResponse getBook = objectMapper.readValue(responseEntity.getBody(), GetBookResponse.class);
                    System.out.println(getBook.toString());


                    //
                    return new ResponseEntity<>(getBook, HttpStatus.OK);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();

                    return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST);
                }
            }


        }

        return null;
    }
}
