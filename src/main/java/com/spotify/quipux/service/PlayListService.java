package com.spotify.quipux.service;

import com.spotify.quipux.model.PlayList;

import java.util.List;

public interface PlayListService {

    PlayList createPlayList(PlayList playList);
    List<PlayList> getALlPlayList();
    PlayList getPlayListByName(String name);
    void deletePlayList(String name);
}
