package com.thoughtworks.capacity.gtb.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MyException.class)
    public ErrorMessage myExceptionHandler(MyException e) {
        return new ErrorMessage(e.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ErrorMessage methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        return new ErrorMessage(e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ErrorMessage constraintViolationExceptionHandler(ConstraintViolationException e){
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        String message="";
        for(ConstraintViolation<?> constraint :constraintViolations){
            message=constraint.getMessage();
            break;
        }
        return new ErrorMessage(message);
    }


}
