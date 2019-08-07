package com.stackroute.muzixapp.controller;

import com.stackroute.muzixapp.dao.TrackDAO;
import com.stackroute.muzixapp.exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exception.TrackNotFoundException;
import com.stackroute.muzixapp.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class TrackController {

	private TrackDAO trackDAO;
private ResponseEntity responseEntity;
	@Autowired
	public TrackController(TrackDAO trackDAO) {
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
	public ResponseEntity<?> saveTrack(@RequestBody Track track) {

		try {

			responseEntity = new ResponseEntity(trackDAO.saveTrack(track), HttpStatus.OK);

		} catch(TrackAlreadyExistsException e) {
			responseEntity = new ResponseEntity<String>("Track already exists", HttpStatus.CONFLICT);
		}
		return responseEntity;
	}

   @PostMapping("add") //mapping for addTrack
	public ResponseEntity<?> addTrack(@RequestBody Track track) {

		try{
			trackDAO.addNewTrack(track);
			responseEntity = new ResponseEntity<String>("Succesfully Added", HttpStatus.OK);
		}
		catch (TrackAlreadyExistsException e){
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		return responseEntity;

	}

  @DeleteMapping("/delete/{id}") //mapping for deleteTrack
	public ResponseEntity<?> deleteTrack(@PathVariable(value = "id") int trackId) {


		try{

			responseEntity = new ResponseEntity<String>("Succesfully deleted", HttpStatus.OK);
		}
		catch (Exception e){
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		return responseEntity;
	}

     @PutMapping("update/{id}") //mapping for updateTrack
	public ResponseEntity<?> updateTrack(@RequestParam(value = "id")int trackId, @RequestBody Track trackDetails) throws TrackAlreadyExistsException {

		try{

			responseEntity = new ResponseEntity(trackDAO.updateTrack(trackId,trackDetails), HttpStatus.OK);
		}
		catch (TrackNotFoundException e){
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		return responseEntity;
	}

	@GetMapping("/byName/{name}") //mapping for byName
	public ResponseEntity<?> trackByName(@PathVariable(value = "name") String name) {

		try{

			responseEntity = new ResponseEntity<List>(trackDAO.searchByName(name), HttpStatus.OK);
		}
		catch (Exception e){
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		return responseEntity;
	}




}