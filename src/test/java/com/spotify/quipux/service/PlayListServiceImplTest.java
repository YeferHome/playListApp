package com.spotify.quipux.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.spotify.quipux.exception.ResourceNotFoundException;
import com.spotify.quipux.model.PlayList;
import com.spotify.quipux.model.Song;
import com.spotify.quipux.repository.PlayListRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PlayListServiceImpl.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class PlayListServiceImplTest {

    @Autowired
    private PlayListServiceImpl playListServiceImpl;

    @MockBean
    private PlayListRepository playListRepository;

    /**
     * Test {@link PlayListServiceImpl#createPlayList(PlayList)}.
     * <p>
     * Method under test: {@link PlayListServiceImpl#createPlayList(PlayList)}
     */
    @Test
    @DisplayName("Test createPlayList(PlayList)")
    @Tag("MaintainedByDiffblue")
    void testCreatePlayList() {
        // Arrange
        when(playListRepository.save(Mockito.<PlayList>any())).thenThrow(new IllegalArgumentException("foo"));

        PlayList playList = new PlayList();
        playList.setDescription("The characteristics of someone or something");
        playList.setId(1L);
        playList.setName("Name");
        playList.setSongs(new ArrayList<>());

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> playListServiceImpl.createPlayList(playList));
        verify(playListRepository).save(isA(PlayList.class));
    }

    /**
     * Test {@link PlayListServiceImpl#createPlayList(PlayList)}.
     * <ul>
     *   <li>Given {@link ArrayList#ArrayList()}.</li>
     *   <li>When {@link PlayList#PlayList()} Name is {@code Name}.</li>
     *   <li>Then return {@link PlayList#PlayList()}.</li>
     * </ul>
     * <p>
     * Method under test: {@link PlayListServiceImpl#createPlayList(PlayList)}
     */
    @Test
    @DisplayName("Test createPlayList(PlayList); given ArrayList(); when PlayList() Name is 'Name'; then return PlayList()")
    @Tag("MaintainedByDiffblue")
    void testCreatePlayList_givenArrayList_whenPlayListNameIsName_thenReturnPlayList() {
        // Arrange
        PlayList playList = new PlayList();
        playList.setDescription("The characteristics of someone or something");
        playList.setId(1L);
        playList.setName("Name");
        playList.setSongs(new ArrayList<>());
        when(playListRepository.save(Mockito.<PlayList>any())).thenReturn(playList);

        PlayList playList2 = new PlayList();
        playList2.setDescription("The characteristics of someone or something");
        playList2.setId(1L);
        playList2.setName("Name");
        playList2.setSongs(new ArrayList<>());

        // Act
        PlayList actualCreatePlayListResult = playListServiceImpl.createPlayList(playList2);

        // Assert
        verify(playListRepository).save(isA(PlayList.class));
        assertSame(playList, actualCreatePlayListResult);
    }

    /**
     * Test {@link PlayListServiceImpl#createPlayList(PlayList)}.
     * <ul>
     *   <li>Given empty string.</li>
     *   <li>When {@link PlayList#PlayList()} Name is empty string.</li>
     * </ul>
     * <p>
     * Method under test: {@link PlayListServiceImpl#createPlayList(PlayList)}
     */
    @Test
    @DisplayName("Test createPlayList(PlayList); given empty string; when PlayList() Name is empty string")
    @Tag("MaintainedByDiffblue")
    void testCreatePlayList_givenEmptyString_whenPlayListNameIsEmptyString() {
        // Arrange
        PlayList playList = new PlayList();
        playList.setDescription("The characteristics of someone or something");
        playList.setId(1L);
        playList.setName("");
        playList.setSongs(null);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> playListServiceImpl.createPlayList(playList));
    }

    /**
     * Test {@link PlayListServiceImpl#createPlayList(PlayList)}.
     * <ul>
     *   <li>Given {@link PlayListRepository}.</li>
     *   <li>When {@link PlayList#PlayList()} Name is {@code null}.</li>
     * </ul>
     * <p>
     * Method under test: {@link PlayListServiceImpl#createPlayList(PlayList)}
     */
    @Test
    @DisplayName("Test createPlayList(PlayList); given PlayListRepository; when PlayList() Name is 'null'")
    @Tag("MaintainedByDiffblue")
    void testCreatePlayList_givenPlayListRepository_whenPlayListNameIsNull() {
        // Arrange
        PlayList playList = new PlayList();
        playList.setDescription("The characteristics of someone or something");
        playList.setId(1L);
        playList.setName(null);
        playList.setSongs(null);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> playListServiceImpl.createPlayList(playList));
    }

    /**
     * Test {@link PlayListServiceImpl#createPlayList(PlayList)}.
     * <ul>
     *   <li>Given {@code Play List}.</li>
     *   <li>When {@link PlayList#PlayList()} Name is {@code Play List}.</li>
     *   <li>Then return {@link PlayList#PlayList()}.</li>
     * </ul>
     * <p>
     * Method under test: {@link PlayListServiceImpl#createPlayList(PlayList)}
     */
    @Test
    @DisplayName("Test createPlayList(PlayList); given 'Play List'; when PlayList() Name is 'Play List'; then return PlayList()")
    @Tag("MaintainedByDiffblue")
    void testCreatePlayList_givenPlayList_whenPlayListNameIsPlayList_thenReturnPlayList() {
        // Arrange
        PlayList playList = new PlayList();
        playList.setDescription("The characteristics of someone or something");
        playList.setId(1L);
        playList.setName("Name");
        playList.setSongs(new ArrayList<>());
        when(playListRepository.save(Mockito.<PlayList>any())).thenReturn(playList);

        PlayList playList2 = new PlayList();
        playList2.setDescription("The characteristics of someone or something");
        playList2.setId(1L);
        playList2.setName("Play List");
        playList2.setSongs(null);

        // Act
        PlayList actualCreatePlayListResult = playListServiceImpl.createPlayList(playList2);

        // Assert
        verify(playListRepository).save(isA(PlayList.class));
        assertSame(playList, actualCreatePlayListResult);
    }

    /**
     * Test {@link PlayListServiceImpl#createPlayList(PlayList)}.
     * <ul>
     *   <li>Given {@link Song#Song()} Album is {@code Album}.</li>
     *   <li>Then return {@link PlayList#PlayList()}.</li>
     * </ul>
     * <p>
     * Method under test: {@link PlayListServiceImpl#createPlayList(PlayList)}
     */
    @Test
    @DisplayName("Test createPlayList(PlayList); given Song() Album is 'Album'; then return PlayList()")
    @Tag("MaintainedByDiffblue")
    void testCreatePlayList_givenSongAlbumIsAlbum_thenReturnPlayList() {
        // Arrange
        PlayList playList = new PlayList();
        playList.setDescription("The characteristics of someone or something");
        playList.setId(1L);
        playList.setName("Name");
        playList.setSongs(new ArrayList<>());
        when(playListRepository.save(Mockito.<PlayList>any())).thenReturn(playList);

        PlayList playlist = new PlayList();
        playlist.setDescription("The characteristics of someone or something");
        playlist.setId(1L);
        playlist.setName("Name");
        playlist.setSongs(new ArrayList<>());

        Song song = new Song();
        song.setAlbum("Album");
        song.setAnno("Anno");
        song.setArtista("Artista");
        song.setGenero("Genero");
        song.setId(1L);
        song.setPlaylist(playlist);
        song.setTitulo("Titulo");

        ArrayList<Song> songs = new ArrayList<>();
        songs.add(song);

        PlayList playList2 = new PlayList();
        playList2.setDescription("The characteristics of someone or something");
        playList2.setId(1L);
        playList2.setName("Name");
        playList2.setSongs(songs);

        // Act
        PlayList actualCreatePlayListResult = playListServiceImpl.createPlayList(playList2);

        // Assert
        verify(playListRepository).save(isA(PlayList.class));
        assertSame(playList, actualCreatePlayListResult);
    }

    @Test
    @DisplayName("Test getALlPlayList(); given PlayListRepository findAll() return ArrayList(); then return Empty")
    @Tag("MaintainedByDiffblue")
    void testGetALlPlayList_givenPlayListRepositoryFindAllReturnArrayList_thenReturnEmpty() {
        // Arrange
        when(playListRepository.findAll()).thenReturn(new ArrayList<>());

        // Act
        List<PlayList> actualALlPlayList = playListServiceImpl.getALlPlayList();

        // Assert
        verify(playListRepository).findAll();
        assertTrue(actualALlPlayList.isEmpty());
    }

    /**
     * Test {@link PlayListServiceImpl#getALlPlayList()}.
     * <ul>
     *   <li>Then throw {@link IllegalArgumentException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link PlayListServiceImpl#getALlPlayList()}
     */
    @Test
    @DisplayName("Test getALlPlayList(); then throw IllegalArgumentException")
    @Tag("MaintainedByDiffblue")
    void testGetALlPlayList_thenThrowIllegalArgumentException() {
        // Arrange
        when(playListRepository.findAll()).thenThrow(new IllegalArgumentException("foo"));

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> playListServiceImpl.getALlPlayList());
        verify(playListRepository).findAll();
    }
    @Test
    @DisplayName("Test getPlayListByName(String); then return PlayList()")
    @Tag("MaintainedByDiffblue")
    void testGetPlayListByName_thenReturnPlayList() {
        // Arrange
        PlayList playList = new PlayList();
        playList.setDescription("The characteristics of someone or something");
        playList.setId(1L);
        playList.setName("Name");
        playList.setSongs(new ArrayList<>());
        Optional<PlayList> ofResult = Optional.of(playList);
        when(playListRepository.findByName(Mockito.<String>any())).thenReturn(ofResult);

        // Act
        PlayList actualPlayListByName = playListServiceImpl.getPlayListByName("Name");

        // Assert
        verify(playListRepository).findByName(eq("Name"));
        assertSame(playList, actualPlayListByName);
    }

    /**
     * Test {@link PlayListServiceImpl#getPlayListByName(String)}.
     * <ul>
     *   <li>Then throw {@link IllegalArgumentException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link PlayListServiceImpl#getPlayListByName(String)}
     */
    @Test
    @DisplayName("Test getPlayListByName(String); then throw IllegalArgumentException")
    @Tag("MaintainedByDiffblue")
    void testGetPlayListByName_thenThrowIllegalArgumentException() {
        // Arrange
        when(playListRepository.findByName(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> playListServiceImpl.getPlayListByName("Name"));
        verify(playListRepository).findByName(eq("Name"));
    }

    /**
     * Test {@link PlayListServiceImpl#getPlayListByName(String)}.
     * <ul>
     *   <li>Then throw {@link ResourceNotFoundException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link PlayListServiceImpl#getPlayListByName(String)}
     */
    @Test
    @DisplayName("Test getPlayListByName(String); then throw ResourceNotFoundException")
    @Tag("MaintainedByDiffblue")
    void testGetPlayListByName_thenThrowResourceNotFoundException() {
        // Arrange
        Optional<PlayList> emptyResult = Optional.empty();
        when(playListRepository.findByName(Mockito.<String>any())).thenReturn(emptyResult);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> playListServiceImpl.getPlayListByName("Name"));
        verify(playListRepository).findByName(eq("Name"));
    }

    @Test
    @DisplayName("Test deletePlayList(String); given PlayListRepository delete(Object) does nothing; then calls delete(Object)")
    @Tag("MaintainedByDiffblue")
    void testDeletePlayList_givenPlayListRepositoryDeleteDoesNothing_thenCallsDelete() {
        // Arrange
        PlayList playList = new PlayList();
        playList.setDescription("The characteristics of someone or something");
        playList.setId(1L);
        playList.setName("Name");
        playList.setSongs(new ArrayList<>());
        Optional<PlayList> ofResult = Optional.of(playList);
        doNothing().when(playListRepository).delete(Mockito.<PlayList>any());
        when(playListRepository.findByName(Mockito.<String>any())).thenReturn(ofResult);

        // Act
        playListServiceImpl.deletePlayList("Name");

        // Assert
        verify(playListRepository).findByName(eq("Name"));
        verify(playListRepository).delete(isA(PlayList.class));
    }

    /**
     * Test {@link PlayListServiceImpl#deletePlayList(String)}.
     * <ul>
     *   <li>Then throw {@link IllegalArgumentException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link PlayListServiceImpl#deletePlayList(String)}
     */
    @Test
    @DisplayName("Test deletePlayList(String); then throw IllegalArgumentException")
    @Tag("MaintainedByDiffblue")
    void testDeletePlayList_thenThrowIllegalArgumentException() {
        // Arrange
        PlayList playList = new PlayList();
        playList.setDescription("The characteristics of someone or something");
        playList.setId(1L);
        playList.setName("Name");
        playList.setSongs(new ArrayList<>());
        Optional<PlayList> ofResult = Optional.of(playList);
        doThrow(new IllegalArgumentException("foo")).when(playListRepository).delete(Mockito.<PlayList>any());
        when(playListRepository.findByName(Mockito.<String>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> playListServiceImpl.deletePlayList("Name"));
        verify(playListRepository).findByName(eq("Name"));
        verify(playListRepository).delete(isA(PlayList.class));
    }

    /**
     * Test {@link PlayListServiceImpl#deletePlayList(String)}.
     * <ul>
     *   <li>Then throw {@link ResourceNotFoundException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link PlayListServiceImpl#deletePlayList(String)}
     */
    @Test
    @DisplayName("Test deletePlayList(String); then throw ResourceNotFoundException")
    @Tag("MaintainedByDiffblue")
    void testDeletePlayList_thenThrowResourceNotFoundException() {
        // Arrange
        Optional<PlayList> emptyResult = Optional.empty();
        when(playListRepository.findByName(Mockito.<String>any())).thenReturn(emptyResult);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> playListServiceImpl.deletePlayList("Name"));
        verify(playListRepository).findByName(eq("Name"));
    }

}
