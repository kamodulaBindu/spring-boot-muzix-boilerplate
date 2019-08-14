package com.stackroute.muzixapp.service;

import java.util.List;
import java.util.Optional;

import com.stackroute.muzixapp.exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exception.TrackNotFoundException;
import com.stackroute.muzixapp.repository.TrackRepository;

import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.muzixapp.model.Track;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class TrackServiceImpl implements TrackService {
	private TrackRepository trackRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

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

	@Override
	public Track deleteTrack(int id) throws TrackNotFoundException {
		Track deletedTrack = null;
		if(!trackRepository.findById(id).isPresent()){
		throw new TrackNotFoundException();
		}
		else {
			trackRepository.delete(getTrackById(id));
			deletedTrack = getTrackById(id);
		}
	return deletedTrack;
	}

	//getting all the tracks
	@Override
	public List<Track> getAllTracks() {
		return trackRepository.findAll();
	}

	@Override
	public Track getTrackById(int id) throws TrackNotFoundException {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		Track savedTrack = mongoTemplate.findOne(query, Track.class);
		if(savedTrack == null) {
			throw new TrackNotFoundException();
		}
		return savedTrack;
	}

	//updating the track by setting name and comment
	@Override
	public Track UpdateTrack(Track track) throws  TrackNotFoundException {
		Optional<Track> savedTrack= Optional.of(track);
		if(trackRepository.existsById(track.getId())) {
			savedTrack = trackRepository.findById(track.getId());
		}
		return saveTrack(track);
	}

}
