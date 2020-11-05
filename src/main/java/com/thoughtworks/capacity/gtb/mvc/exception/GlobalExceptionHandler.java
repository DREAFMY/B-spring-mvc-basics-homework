package com.thoughtworks.capacity.gtb.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionMessage> handleMethodArgument(MethodArgumentNotValidException e) {
        String mes = e.getBindingResult().getFieldError().getDefaultMessage();
        ExceptionMessage exceptResult = new ExceptionMessage(mes);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptResult);
    }

    @ExceptionHandler({UserExistException.class, LoginException.class})
    public ResponseEntity<ExceptionMessage> handleException(Exception e) {
        String mes = e.getMessage();
        ExceptionMessage exceptionMessage = new ExceptionMessage(mes);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionMessage);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionMessage> handle(ConstraintViolationException e) {
        String mes = "";
        for (ConstraintViolation<?> constrain : e.getConstraintViolations()) {
            mes = constrain.getMessage();
            break;
        }
        ExceptionMessage exceptionMessage = new ExceptionMessage(mes);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionMessage);
    }
}
