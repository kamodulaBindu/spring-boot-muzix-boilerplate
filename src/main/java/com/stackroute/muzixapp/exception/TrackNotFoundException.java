package com.stackroute.muzixapp.exception;

import com.stackroute.muzixapp.model.Track;
//class for TrackNotFoundException
public class TrackNotFoundException extends Exception {
    private String message;

    public TrackNotFoundException(String message){
        super(message);
        this.message=message;
    }
}

