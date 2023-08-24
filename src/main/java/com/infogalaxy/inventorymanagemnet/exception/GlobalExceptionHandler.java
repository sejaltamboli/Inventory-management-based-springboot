package com.infogalaxy.inventorymanagemnet.exception;

import com.infogalaxy.inventorymanagemnet.responses.Responses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity itemNotFoundEx(ItemNotFoundException ex){
        return new ResponseEntity<>(new Responses("Item with Given ID not Found", HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);

    }
}
