package com.stackroute.muzixapp.dao;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.stackroute.muzixapp.exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exception.TrackNotFoundException;
import com.stackroute.muzixapp.repository.TrackRepository;

import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.muzixapp.model.Track;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
			throw new TrackAlreadyExistsException();
		}
		Track savedTrack =  trackRepository.save(track);
		if(savedTrack==null) {
			throw new TrackAlreadyExistsException();
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
			throw new TrackAlreadyExistsException();
		}
		Track addTrack =  trackRepository.save(track);
		if(addTrack==null) {
			throw new TrackAlreadyExistsException();
		}
		return addTrack;
	}



	@Override
	public Track updateTrack(int trackId, Track trackDetails) throws TrackNotFoundException {
		if(trackRepository.existsById(trackId)) {
			throw new TrackNotFoundException();
		}

		Track updatedTrack = trackRepository.findById(trackId).get();
		updatedTrack.setName(trackDetails.getName());
		updatedTrack.setComment(trackDetails.getComment());
		trackRepository.save(updatedTrack);
		if(updatedTrack==null) {
			throw new TrackNotFoundException();
		}

	    return updatedTrack;

	}

	@Override
	public void deleteTrackById(int Id) throws TrackNotFoundException {
		if(trackRepository.existsById(Id)) {
			throw new TrackNotFoundException();
		}

		trackRepository.deleteById(Id);
	}

	@Override
	public List<Track> searchByName(String name) {

				List<Track> track = trackRepository.findByName(name);
				return track;

	}

	@Override
	public void getTopTracks() {
		final String uri = "http://ws.audioscrobbler.com/2.0/?method=geo.gettoptracks&country=spain&api_key=cab7e4d64efe25c17360d5a74d8fa89b&format=json";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);


		//Object Mapper to access the JSON from the response entity
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = null;

		//read the response body to get JSON object
		try {
			root = mapper.readTree(result.getBody());
			ArrayNode arrayNode = (ArrayNode) root.path("tracks").path("track");

			//iterate the JSON array
			for (int i = 0; i < arrayNode.size(); i++) {
				//get a new Track object and fill it with data using setters
				Track track = new Track();
				track.setName(arrayNode.get(i).path("name").asText());
				track.setComment(arrayNode.get(i).path("artist").path("name").asText());
				//save the track to database
				trackRepository.save(track);
			}



		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	@Override
	public Track getTrackById(int id) throws TrackNotFoundException {
		//check if track exists
		if (!trackRepository.existsById(id)) {
			//throw custom exception
			throw new TrackNotFoundException();
		}
		//otherwise get the track
		return trackRepository.findById(id).orElse(null);
	}

}

