package com.stackroute.muzixapp;

import com.stackroute.muzixapp.dao.TrackDAO;
import com.stackroute.muzixapp.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class ApplicationListenerSpringBoot implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    TrackDAO trackDAO;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Track track = new Track(2,"hello","hiii");
        try{
            trackDAO.saveTrack(track);
            for(Track track1 : trackDAO.getAllTracks()){
                System.out.println(trackDAO.getAllTracks());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
