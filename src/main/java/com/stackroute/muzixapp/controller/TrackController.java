package com.stackroute.muzixapp.controller;

import com.stackroute.muzixapp.dao.TrackDAO;
import com.stackroute.muzixapp.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1")
public class TrackController {
private ResponseEntity responseEntity;
	private TrackDAO trackDAO;

	@Autowired
	public TrackController(TrackDAO trackDAO) {
		this.trackDAO = trackDAO;
	}

//update all the methods with code

     @PostMapping("save")
	public ResponseEntity<?> saveTrack(@RequestBody Track track) {

		try {
			trackDAO.saveTrack(track);
			responseEntity = new ResponseEntity<String>("Succesfully Created", HttpStatus.OK);

		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		return responseEntity;
	}

   @PostMapping("add")
	public ResponseEntity<?> addTrack(@RequestBody Track track) {

		try{
			trackDAO.addNewTrack(track);
			responseEntity = new ResponseEntity<String>("Succesfully Added", HttpStatus.OK);
		}
		catch (Exception e){
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		return responseEntity;

	}

  @DeleteMapping("delete")
	public ResponseEntity<?> deleteTrack(Track track) {


		try{
			trackDAO.deleteTrackById(track.getId());
			responseEntity = new ResponseEntity<String>("Succesfully deleted", HttpStatus.OK);
		}
		catch (Exception e){
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		return responseEntity;
	}

     @PutMapping("update")
	public ResponseEntity<?> updateTrack(Track track) {

		try{
			trackDAO.updateTrack(track);
			responseEntity = new ResponseEntity<String>("Succesfully Added", HttpStatus.OK);
		}
		catch (Exception e){
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		return responseEntity;
	}

}