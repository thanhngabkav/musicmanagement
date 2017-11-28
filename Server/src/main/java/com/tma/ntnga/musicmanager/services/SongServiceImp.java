/**
 * Classname : SongServiceTest
 * Version : 1.0
 */

package com.tma.ntnga.musicmanager.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tma.ntnga.musicmanager.dataAccess.SongRepository;
import com.tma.ntnga.musicmanager.entities.Song;
import com.tma.ntnga.musicmanager.messageHandler.MusicMessageHandler;
import com.tma.ntnga.musicmanager.models.MessageStatus;
import com.tma.ntnga.musicmanager.models.MusicManagerMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.naming.NamingException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
@ManagedResource(objectName = "SongService:name=Resource")
public class SongServiceImp implements SongService, Serializable {

    static Logger log = Logger.getLogger(SongServiceImp.class.getName());

    @Autowired
    private MusicMessageHandler musicMessageHandler;

    @Autowired
    private SongRepository songRepository;

    @ManagedOperation
    @Override
    public void updateSong(Song song) throws JMSException, NamingException, JsonProcessingException {
        songRepository.save(song);
        log.info("Updated song: "+ song.toString());
        musicMessageHandler.sendMessage(
                new MusicManagerMessage(MessageStatus.UPDATED,song));
    }

    @ManagedOperation
    @Override
    public void createSong(Song song) throws JMSException, NamingException, JsonProcessingException {
        songRepository.save(song);
        log.info("Created song: "+ song.toString());
        musicMessageHandler.sendMessage(
                new MusicManagerMessage(MessageStatus.CREATED,song));
    }

    @ManagedOperation
    @Override
    public void deleteSong(Song song) throws JMSException, NamingException, JsonProcessingException {
        songRepository.delete(song);
        log.info("Deleted song: "+ song.toString());
        musicMessageHandler.sendMessage(
                new MusicManagerMessage(MessageStatus.DELETED,song));
    }

    @ManagedOperation
    @Override
    public Song getSongById(int songId) {
        return songRepository.findOne(songId);
    }

    @ManagedOperation
    @Override
    public List<Song> findSongByName(String name) {
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song(1,"2","3"));
        return songs;
    }

    @ManagedOperation
    @Override
    public List<Song> getAllSongs() {
        List<Song> songList = new ArrayList<Song>();
        songList =  (List<Song>) songRepository.findAll();
        return songList;
    }
}
