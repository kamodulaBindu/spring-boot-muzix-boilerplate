package com.stackroute.muzixapp.service;


import java.util.List;
import java.util.Optional;

import com.stackroute.muzixapp.exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exception.TrackNotFoundException;
import com.stackroute.muzixapp.model.Track;



public interface TrackService {

	public Track saveTrack(Track track) throws TrackAlreadyExistsException;

	public Track deleteTrack(int id) throws TrackNotFoundException;

	public List<Track> getAllTracks();

	public Track getTrackById(int id);

	public Track UpdateTrack(Track track) throws TrackNotFoundException;




}