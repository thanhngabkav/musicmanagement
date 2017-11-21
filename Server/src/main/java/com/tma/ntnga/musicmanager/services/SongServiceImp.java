/**
 * Classname : SongServiceTest
 * Version : 1.0
 */

package com.tma.ntnga.musicmanager.services;

import com.tma.ntnga.musicmanager.entities.Song;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImp implements SongService{

    @Override
    public void updateSong(Song song) {

    }

    @Override
    public void createSong(Song song) {

    }

    @Override
    public void deleteSong(Song song) {

    }

    @Override
    public Song getSongById(int songId) {
        return null;
    }

    @Override
    public List<Song> findSongByName(String name) {
        return null;
    }

    @Override
    public List<Song> getAllSongs() {
        return null;
    }
}
