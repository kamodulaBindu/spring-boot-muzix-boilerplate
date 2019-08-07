package com.stackroute.muzixapp.dao;

import java.util.List;
import java.util.TreeSet;


import com.stackroute.muzixapp.repository.TrackRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.muzixapp.model.Track;
import org.springframework.stereotype.Service;

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

	@Override
	public List<Track> getAllTracks()
	{
		return trackRepository.findAll();
	}

	@Override
	public Track addNewTrack(Track track)
	{
		return trackRepository.save(track);
	}

	@Override
	public Track updateTrack(Track track)
	{
		return trackRepository.save(track);
	}

	@Override
	public List<Track> deleteTrackById(int Id)
	{
		trackRepository.deleteById(Id);
		return trackRepository.findAll();
	}
}
