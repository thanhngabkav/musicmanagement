/**
 * Classname : Song
 * Version : 1.0
 */

package com.tma.ntnga.musicmanager.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "song")
public class Song implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer songId;

    private  String name;

    private String link;

    /**
     * Default Constructor
     */
    public Song(){ }

    /**
     * Constructor
     * @param songId
     * @param name
     * @param link
     */
    public Song(int songId, String name, String link){
        this.songId = songId;
        this.name = name;
        this.link = link;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        return songId == song.songId;
    }

    @Override
    public int hashCode() {
        return songId;
    }
}
