package com.stackroute.muzixapp;

import com.stackroute.muzixapp.dao.TrackDAO;
import com.stackroute.muzixapp.model.Track;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.logging.Logger;

public class CommandLineRunnerSpring implements CommandLineRunner {

    @Autowired
    TrackDAO trackDAO;

    @Override
    public void run(String... args) throws Exception {
        Logger logger = (Logger) LoggerFactory.getLogger(CommandLineRunnerSpring.class);
        try{
            Track track = new Track(1,"jdiu","gfudwhf");
            trackDAO.saveTrack(track);
            for(Track track1:trackDAO.getAllTracks())
            {
                logger.info(track1.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
