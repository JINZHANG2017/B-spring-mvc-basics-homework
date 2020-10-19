package com.thoughtworks.capacity.gtb.mvc.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exceptionHandler(Exception e) {
        if(e instanceof MyException){
            MyException myException=(MyException)e;
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return  ResponseEntity.status(500).body("服务器出错");
    }
}
