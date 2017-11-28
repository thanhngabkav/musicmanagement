/**
 * Interface : SongService
 * Version : 1.0
 */

package com.tma.ntnga.musicmanager.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tma.ntnga.musicmanager.entities.Song;

import javax.jms.JMSException;
import javax.naming.NamingException;
import java.util.List;

public interface SongService {

    /**
     * Update a song
     * @param song : Song
     */
    void updateSong(Song song) throws JMSException, NamingException, JsonProcessingException;

    /**
     * Create new Song
     * @param song : Song
     */
    void createSong(Song song) throws JMSException, NamingException, JsonProcessingException;

    /**
     * Delete a song
     * @param song : Song
     */
    void deleteSong(Song song) throws JMSException, NamingException, JsonProcessingException;

    /**
     * Get a song by id
     * @param songId : song id
     * @return Song
     */
    Song getSongById(int songId);

    /**
     * Find list songs have name contain input
     * @param name : song's name
     * @return
     */
    List<Song> findSongByName(String name);

    /**
     *Get All songs in Database
     * @return List Song
     */
    List<Song> getAllSongs();
}
