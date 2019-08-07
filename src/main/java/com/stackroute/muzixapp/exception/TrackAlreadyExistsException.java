package com.stackroute.muzixapp.exception;

//class for TrackAlreadyExistsException
public class TrackAlreadyExistsException extends Exception {
    private String message;

    public TrackAlreadyExistsException(String message){
        super(message);
        this.message=message;
    }
}

