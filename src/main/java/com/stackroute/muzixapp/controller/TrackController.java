package com.stackroute.muzixapp.controller;

import com.stackroute.muzixapp.service.TrackService;
import com.stackroute.muzixapp.exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exception.TrackNotFoundException;
import com.stackroute.muzixapp.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class TrackController {

private ResponseEntity responseEntity;
	private TrackService trackDAO;
@Autowired
	public TrackController(TrackService trackDAO) {
		this.trackDAO = trackDAO;
	}

//update all the methods with code

	@GetMapping("track") //mapping for gettingAllTracks
	public ResponseEntity<?> getAllTracks() {

		try {

			responseEntity = new ResponseEntity(trackDAO.getAllTracks(), HttpStatus.OK);

		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		return responseEntity;
	}

	@PostMapping("save") //mapping for saving Tracks
	public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException {
				responseEntity = new ResponseEntity(trackDAO.saveTrack(track), HttpStatus.OK);

		return responseEntity;
	}

   @PostMapping("add") //mapping for addTrack
	public ResponseEntity<?> addTrack(@RequestBody Track track) throws TrackAlreadyExistsException {
	   	   responseEntity = new ResponseEntity(trackDAO.saveTrack(track), HttpStatus.OK);

	   return responseEntity;




	}

  @DeleteMapping("/delete/{id}") //mapping for deleteTrack
	public ResponseEntity<?> deleteTrack(@PathVariable(value = "id") int trackId) throws TrackNotFoundException {
	    responseEntity = new ResponseEntity("Succesfully Deleted", HttpStatus.OK);

	  return responseEntity;


  }
	@PutMapping("update")
	public ResponseEntity<?> updateTrack(@RequestBody Track track) throws TrackNotFoundException
	{

		trackDAO.UpdateTrack(track);
		responseEntity = new ResponseEntity<Track>(track, HttpStatus.OK);
		return responseEntity;
	}

}