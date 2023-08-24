package com.infogalaxy.inventorymanagemnet.responses;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Responses {
    private String message;
    private HttpStatus code;
    private Object object;


    public Responses() {
    }

    public Responses(String message) {
        this.message = message;
    }

    public Responses(String message,HttpStatus code){
        this.message = message;
        this.code = code;
    }

    public Responses(String message,HttpStatus code,Object object){
        this.message = message;
        this.code = code;
        this.object = object;
    }

}
