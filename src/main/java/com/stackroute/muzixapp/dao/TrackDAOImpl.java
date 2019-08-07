package com.stackroute.muzixapp.dao;

import java.util.List;
import java.util.Optional;
import java.util.TreeSet;


import com.stackroute.muzixapp.exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exception.TrackNotFoundException;
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
	public Track saveTrack(Track track) throws TrackAlreadyExistsException {
		if(trackRepository.existsById(track.getId())) {
			throw new TrackAlreadyExistsException("Track already exists");
		}
		Track savedTrack =  trackRepository.save(track);
		if(savedTrack==null) {
			throw new TrackAlreadyExistsException("Track already exists");
		}
		return savedTrack;
	}
//implementation of crud methods
	@Override
	public List<Track> getAllTracks() {
		return trackRepository.findAll();
	}

	@Override
	public Track addNewTrack(Track track) throws TrackAlreadyExistsException

	{
		if(trackRepository.existsById(track.getId())) {
			throw new TrackAlreadyExistsException("Track already exists");
		}
		Track addTrack =  trackRepository.save(track);
		if(addTrack==null) {
			throw new TrackAlreadyExistsException("Track already exists");
		}
		return addTrack;
	}



	@Override
	public Track updateTrack(int trackId, Track trackDetails) throws TrackNotFoundException {
		if(trackRepository.existsById(trackId)) {
			throw new TrackNotFoundException("Track not found");
		}

		Track updatedTrack = trackRepository.findById(trackId).get();
		updatedTrack.setName(trackDetails.getName());
		updatedTrack.setComment(trackDetails.getComment());
		trackRepository.save(updatedTrack);
		if(updatedTrack==null) {
			throw new TrackNotFoundException("Track not found");
		}

	    return updatedTrack;

	}

	@Override
	public List<Track> deleteTrackById(int Id) throws TrackNotFoundException {
		if(trackRepository.existsById(Id)) {
			throw new TrackNotFoundException("Track not found");
		}


		trackRepository.deleteById(Id);
		return trackRepository.findAll();
	}

	@Override
	public List<Track> searchByName(String name) {

				List<Track> track = trackRepository.findByName(name);
				return track;

	}
}
