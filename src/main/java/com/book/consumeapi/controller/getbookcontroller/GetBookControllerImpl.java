package com.book.consumeapi.controller.getbookcontroller;

import com.book.consumeapi.model.getbook.GetBookResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
public class GetBookControllerImpl implements GetBookController{

    private Logger log = LoggerFactory.getLogger(GetBookControllerImpl.class);

    @Value("${mvc.basepath}")
    private String basePath;

    @Value("${mvc.getendpoint}")
    private String getEndPoint;

    @Value("${mvc.getendpointbyid}")
    private String getEntPointById;

    @Autowired
    private ObjectMapper objectMapper;

    private RestTemplate restTemplate = new RestTemplate();


    @Override
    public ResponseEntity<?> getBook() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<String> responseEntity = restTemplate.exchange(basePath+getEndPoint,
                                                                       HttpMethod.GET,
                                                                       httpEntity,
                                                                       String.class );

        if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {

            try {

                GetBookResponse getBook = objectMapper.readValue(responseEntity.getBody(), GetBookResponse.class);
                return new ResponseEntity<>(getBook, HttpStatus.OK);

            } catch (JsonProcessingException e) {

                e.printStackTrace();
                return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST);
            }

        }
        return null;
    }

    @Override
    public ResponseEntity<?> getBookById(Optional<Integer> bookId) {

        log.info("Called /rest-getBook");
        log.debug("Called /rest-getBook witch bookId = " + bookId);

        if (bookId.isPresent()) {

            log.info("BookId is present");
            log.debug("BookId = " + bookId.get());

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

            HttpEntity httpEntity = new HttpEntity(httpHeaders);

            ResponseEntity<String> responseEntity = restTemplate.exchange(basePath+getEntPointById+"?bookId={id}",
                                                                           HttpMethod.GET,
                                                                           httpEntity,
                                                                           String.class,
                                                                           bookId.get() );

            if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {

                try {

                    GetBookResponse getBook = objectMapper.readValue(responseEntity.getBody(), GetBookResponse.class);

                    log.info("Book found and added to the list");
                    log.debug("Book found and added: " + getBook.toString());

                    return new ResponseEntity<>(getBook, HttpStatus.OK);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();

                    log.info("No book was found");
                    log.debug("No book was found whit bookId = " + bookId.get());

                    return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST);
                }
            }


        }

        return null;
    }
}
