package com.infogalaxy.inventorymanagemnet.exception;

import com.infogalaxy.inventorymanagemnet.responses.Responses;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity itemNotFoundEx(ItemNotFoundException ex){
        return new ResponseEntity<>(new Responses("Item with Given ID not Found", HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String,String> errorMap = new HashMap<>();
        for(FieldError field : ex.getFieldErrors()) {
            errorMap.put(field.getField(),field.getDefaultMessage());
            //logger.info(field.getField()+"="+field.getDefaultMessage());
        }


        return new ResponseEntity<>(new Responses("Please Check the Input Data",HttpStatus.BAD_REQUEST,errorMap),HttpStatus.BAD_REQUEST);
    }
}
