package com.stackroute.muzixapp.controller;
import com.stackroute.muzixapp.exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exception.TrackNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TrackExceptionController {

    @ExceptionHandler(value = TrackAlreadyExistsException.class)
    public ResponseEntity<Object> handleException(TrackAlreadyExistsException e)
    {
        return new ResponseEntity<>("Track already exists", HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(value = TrackNotFoundException.class)
    public ResponseEntity<Object> handleExceptions(TrackNotFoundException e)
    {
        return new ResponseEntity<>("Track does not exist", HttpStatus.NOT_FOUND);

    }

}