package com.stackroute.muzixapp.dao;

import java.util.List;
import java.util.Optional;
import java.util.TreeSet;


import com.stackroute.muzixapp.repository.TrackRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.muzixapp.model.Track;
import org.springframework.stereotype.Service;
//service class
@Service
public class TrackDAOImpl implements TrackDAO {


	TrackRepository trackRepository;

	@Autowired
	public TrackDAOImpl(TrackRepository trackRepository) {

		this.trackRepository = trackRepository;
	}

	@Override
	public Track saveTrack(Track track) {
		Track savedTrack =  trackRepository.save(track);
		return savedTrack;
	}
//implementation of crud methods
	@Override
	public List<Track> getAllTracks() {
		return trackRepository.findAll();
	}

	@Override
	public Track addNewTrack(Track track)
	{
		return trackRepository.save(track);
	}

	@Override
	public Track updateTrack(int trackId, Track trackDetails)
	{
		//Track updatedTrack=trackRepository.findById(trackId).orElseThrow()->new TrackNotFound("track not found"));
	    Track updatedTrack = trackRepository.findById(trackId).get();
	    updatedTrack.setName(trackDetails.getName());
	    updatedTrack.setComment(trackDetails.getComment());
	    trackRepository.save(updatedTrack);
	    return updatedTrack;

	}

	@Override
	public List<Track> deleteTrackById(int Id)
	{
		trackRepository.deleteById(Id);
		return trackRepository.findAll();
	}

	@Override
	public List<Track> searchByName(String name) {
				List<Track> track = trackRepository.findByName(name);
				return track;

	}
}
