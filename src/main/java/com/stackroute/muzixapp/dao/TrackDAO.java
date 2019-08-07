package com.stackroute.muzixapp.dao;


import java.util.List;

import com.stackroute.muzixapp.model.Track;

public interface TrackDAO {

	public Track saveTrack(Track track);

	public List<Track> getAllTracks();

	public Track addNewTrack(Track track);

	public Track updateTrack(Track track);


	public List<Track> deleteTrackById(int Id);

}
