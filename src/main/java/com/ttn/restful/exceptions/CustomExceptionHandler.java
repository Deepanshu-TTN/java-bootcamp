package com.ttn.restful.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllException(Exception e, WebRequest request){
        ErrorDetail errorDetail = new ErrorDetail(
                LocalDateTime.now(),
                e.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDetail, HttpStatusCode.valueOf(500));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException e, WebRequest request){
        ErrorDetail errorDetail = new ErrorDetail(
                LocalDateTime.now(),
                e.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDetail, HttpStatusCode.valueOf(404));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleInvalidException(MethodArgumentNotValidException e, WebRequest request){
        ErrorDetail errorDetail = new ErrorDetail(
                LocalDateTime.now(),
                e.getFieldError().getDefaultMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(errorDetail, HttpStatusCode.valueOf(400));
    }
}
