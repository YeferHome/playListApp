package com.spotify.quipux.repository;

import com.spotify.quipux.model.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayListRepository extends JpaRepository<PlayList, Long> {

    Optional<PlayList> findByName(String name);

    boolean existsByName(String name);
}
