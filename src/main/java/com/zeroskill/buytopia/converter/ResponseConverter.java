package com.zeroskill.buytopia.converter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseConverter {
    public static <T> ResponseEntity<T> convertToResponseEntity(T response) {
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
