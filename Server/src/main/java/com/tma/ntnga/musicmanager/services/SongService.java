/**
 * Interface : SongService
 * Version : 1.0
 */

package com.tma.ntnga.musicmanager.services;

import com.tma.ntnga.musicmanager.entities.Song;

import java.util.List;

public interface SongService {

    /**
     * Update a song
     * @param song : Song
     */
    void updateSong(Song song);

    /**
     * Create new Song
     * @param song : Song
     */
    void createSong(Song song);

    /**
     * Delete a song
     * @param song : Song
     */
    void deleteSong(Song song);

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
