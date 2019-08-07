package com.stackroute.muzixapp.service;

import java.util.List;
import java.util.Optional;

import com.stackroute.muzixapp.exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exception.TrackNotFoundException;
import com.stackroute.muzixapp.repository.TrackRepository;

import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.muzixapp.model.Track;
import org.springframework.stereotype.Service;

@Service
public class TrackServiceImpl implements TrackService {
	private TrackRepository trackRepository;

	@Autowired
	public TrackServiceImpl(TrackRepository trackRepository) {
		this.trackRepository=trackRepository;
	}


	@Override
	public Track saveTrack(Track track) throws TrackAlreadyExistsException {
		Track savedTrack = null;
		if(!trackRepository.findById(track.getId()).isPresent()){
		    savedTrack=trackRepository.save(track);
        }

		return savedTrack;
	}

	//getting all the tracks
	@Override
	public List<Track> getAllTracks() {
		return trackRepository.findAll();
	}

	@Override
	public Track getTrackById(int id) {
		return trackRepository.save(getTrackById(id));
	}
	//updating the track by setting name and comment
	@Override
	public Track UpdateTrack(Track track) throws  TrackNotFoundException {
		Optional<Track> savedTrack= Optional.of(new Track());
		if(trackRepository.existsById(track.getId())) {
			savedTrack = trackRepository.findById(track.getId());
		}
		return saveTrack(track);
	}

}
