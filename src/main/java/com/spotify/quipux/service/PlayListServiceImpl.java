package com.spotify.quipux.service;

import com.spotify.quipux.exception.ResourceNotFoundException;
import com.spotify.quipux.model.PlayList;
import com.spotify.quipux.repository.PlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayListServiceImpl implements PlayListService{

    @Autowired
    private PlayListRepository playListRepository;


    @Override
    public PlayList createPlayList(PlayList playList) {
        if (playList.getName() == null || playList.getName().isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        return playListRepository.save(playList);
    }

    @Override
    public List<PlayList> getALlPlayList() {
        return playListRepository.findAll();
    }

    @Override
    public PlayList getPlayListByName(String name) {
        return playListRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("PlayList not found: " + name));
    }

    @Override
    public void deletePlayList(String name) {
        PlayList playList = getPlayListByName(name);
        playListRepository.delete(playList);
    }
}
