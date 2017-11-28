package com.tma.ntnga.musicmanager.services;


import com.tma.ntnga.musicmanager.dataAccess.SongRepository;
import com.tma.ntnga.musicmanager.entities.Song;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by ntnga on 11/24/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SongServiceTest {

    @MockBean
    private SongRepository songRepository;

    @Autowired
    private SongService songService;

    @Test
    public void getSongById_NotFound(){
        Integer songId = 1234;
        when(songRepository.findOne(songId)).thenReturn(null);
        Song expectedResult = null;
        Song actualResult = songService.getSongById(songId);

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void getSongById_Found(){
        Song song = new Song(123,"Nguoi Tinh Mua Dong","https://nhac.vn/nguoi-tinh-mua-dong-nhu-quynh-soPR9X");
        when(songRepository.findOne(song.getSongId())).thenReturn(song);
        Song expectedResult = song;
        Song actualResult = songService.getSongById(song.getSongId());

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void getAllSong_Found(){
        ArrayList<Song> songList = new ArrayList<Song>();
        songList.add(new Song(1,"umbala","google.com"));
        songList.add(new Song(2,"con buom vang","google.com"));
        songList.add(new Song(3,"chuc be ngu ngon","google.com"));
        songList.add(new Song(4,"hon da co don","google.com"));
        when(songRepository.findAll()).thenReturn(songList);
        List<Song> expectedResult = (List)songList;
        List<Song> actualResult = songService.getAllSongs();

        Assert.assertArrayEquals(expectedResult.toArray(),actualResult.toArray());
    }

    @Test
    public void getAllSong_Empty(){
        ArrayList<Song> songList = new ArrayList<Song>();
        when(songRepository.findAll()).thenReturn(songList);
        List<Song> expectedResult = songList;
        List<Song> actualResult = songService.getAllSongs();

        Assert.assertArrayEquals(expectedResult.toArray(),actualResult.toArray());
    }

}

