package com.stackroute.muzixapp.controller;


import com.stackroute.muzixapp.exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exception.TrackNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TrackExceptionController {

    @ExceptionHandler(value = {TrackAlreadyExistsException.class})
    public ResponseEntity<Object> exception(TrackAlreadyExistsException e){
        return new ResponseEntity<>("Track Already Exists", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {TrackNotFoundException.class})
    public ResponseEntity<Object> exceptionTrackNotFound(TrackAlreadyExistsException e){
        return new ResponseEntity<>("Track Not Found", HttpStatus.CONFLICT);
    }
}
