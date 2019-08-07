package com.stackroute.muzixapp.dao;


import java.util.List;

import com.stackroute.muzixapp.exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exception.TrackNotFoundException;
import com.stackroute.muzixapp.model.Track;

public interface TrackDAO {

	//crud methods
	public Track saveTrack(Track track) throws TrackAlreadyExistsException;

	public List<Track> getAllTracks();

	public Track addNewTrack(Track track) throws TrackAlreadyExistsException;

	public Track updateTrack(int trackId, Track trackDetails) throws TrackNotFoundException, TrackAlreadyExistsException;


	public List<Track> deleteTrackById(int Id) throws TrackNotFoundException, TrackAlreadyExistsException;

	public List<Track> searchByName(String name);
	void getTopTracks();
	public Track getTrackById(int id) throws TrackNotFoundException;


}
