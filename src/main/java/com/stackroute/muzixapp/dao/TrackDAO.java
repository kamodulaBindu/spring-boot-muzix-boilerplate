package com.stackroute.muzixapp.dao;


import java.util.List;

import com.stackroute.muzixapp.model.Track;

public interface TrackDAO {

	//crud methods
	public Track saveTrack(Track track);

	public List<Track> getAllTracks();

	public Track addNewTrack(Track track);

	public Track updateTrack(int trackId, Track trackDetails);


	public List<Track> deleteTrackById(int Id);

	public List<Track> searchByName(String name);



}
