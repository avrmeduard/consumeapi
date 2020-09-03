package com.book.consumeapi.controller.deletebookcontroller;

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
public class DeleteBookControllerImpl implements DeleteBookController{

    private Logger log = LoggerFactory.getLogger(DeleteBookControllerImpl.class);

    @Value("${mvc.basepath}")
    private String basePath;

    @Value("${mvc.deleteendpoint}")
    private String deleteEndPoint;

    @Value("${mvc.deleteendpointbyid}")
    private String deleteEndPointById;

    @Autowired
    private ObjectMapper objectMapper;

    private RestTemplate restTemplate = new RestTemplate();


    @Override
    public ResponseEntity<?> deleteBooks() {

        ResponseEntity<Void> responseEntity = restTemplate.exchange(basePath+deleteEndPoint,
                                                                    HttpMethod.DELETE,
                                                                    null,
                                                                    Void.class );

        if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            return new ResponseEntity<String>("All books have been deleted", HttpStatus.OK);
        }

        return new ResponseEntity<String>("Invalid request", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> deleteBookbyId(Optional<Integer> bookId) {

        ResponseEntity<Void> responseEntity = restTemplate.exchange(basePath+deleteEndPointById+"?bookId={id}",
                                                                    HttpMethod.DELETE,
                                                                    null,
                                                                    Void.class,
                                                                    bookId.get());

        if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            return new ResponseEntity<String>("Books whit id " + bookId.get() +
                                                    " has been successfully deleted", HttpStatus.OK);
        }

        return new ResponseEntity<String>("Invalid request", HttpStatus.BAD_REQUEST);
    }
}
