package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalVolleyballRestExceptionHandler {


  @ExceptionHandler
  public ResponseEntity<ErrorDto> handleException(PlayerNotFoundException exception) {
    ErrorDto error =
        ErrorDto
            .builder()
            .status(HttpStatus.NOT_FOUND.value())
            .message(exception.getMessage())
            .timestamp(System.currentTimeMillis())
            .build();

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }


  @ExceptionHandler
  public ResponseEntity<ErrorDto> handleException(Exception exc) {
    ErrorDto error =
        ErrorDto
            .builder()
            .status(HttpStatus.BAD_REQUEST.value())
            .message(exc.getMessage())
            .timestamp(System.currentTimeMillis())
            .build();
    //Como separar el error code bad request de la excepcion generica
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }
}
