package com.stackroute.trackservice.controller;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/")
public class TrackController {
    private TrackService trackService;
    public TrackController() {
    }

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }
    @PostMapping("track")
    public ResponseEntity<Track> saveTrack(@RequestBody Track track){
        Track saveTracks=trackService.saveTrack(track);

        return new ResponseEntity<>(saveTracks,HttpStatus.OK);
    }
    @GetMapping("track/{trackId}")
    public ResponseEntity<?> getTrack(@PathVariable int trackId){
        Track getTracks=trackService.getTrackById(trackId);
        return new ResponseEntity<>(getTracks,HttpStatus.CREATED);
    }
   /* @GetMapping("tracks/")
    public ResponseEntity<?> getAllTracks(){
        Track getAllTracks=trackService.getAllTracks();
        return new ResponseEntity<>(getAllTracks,HttpStatus.CREATED);
    }*/
  @GetMapping("tracks/")
    public ResponseEntity<?> getAllTracks(){
      List<Track> getAllTrackList=trackService.getAllTracks();
      return new ResponseEntity<>(getAllTrackList,HttpStatus.CREATED);
  }

  @DeleteMapping("trackde/{trackId}")
    public ResponseEntity<?> trackDelete(@PathVariable int trackId){
      Optional<Track> trackDelete=trackService.trackDeleteById(trackId);
      return new ResponseEntity<>(trackDelete,HttpStatus.CREATED);
  }
@PatchMapping("trackPatch/{trackId}")
    public ResponseEntity<?> updateTrack(@RequestParam Track track){
      Track trackUpdate=trackService.updateTrack(track);
      return new ResponseEntity<>(trackUpdate,HttpStatus.CREATED);
}

}



