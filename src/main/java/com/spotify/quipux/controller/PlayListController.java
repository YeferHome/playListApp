package com.spotify.quipux.controller;

import com.spotify.quipux.model.PlayList;
import com.spotify.quipux.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/quipux/lists")
public class PlayListController {

    @Autowired
    private PlayListService playListService;

    @PostMapping
    public ResponseEntity<PlayList> createPlayList(@RequestBody PlayList playList, UriComponentsBuilder uriBuilder) {
        PlayList created = playListService.createPlayList(playList);
        URI location = uriBuilder.path("/api/quipux/lists/{nombre}")
                .buildAndExpand(created.getName ()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping
    public List<PlayList> getAllPlayLists() {
        return playListService.getALlPlayList();
    }

    @GetMapping("/{listName}")
    public PlayList getPlayListByName(@PathVariable("listName") String listName) {
        return playListService.getPlayListByName(listName);

    }

    @DeleteMapping("/{listName}")
    public ResponseEntity<Void> deletePlayList(@PathVariable("listName") String listName) {
        playListService.deletePlayList(listName);
        return ResponseEntity.noContent().build();
    }

}