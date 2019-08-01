package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track);
    public Track getTrackById(int trackId);
//    public List<Track> getAllTracks();

}
