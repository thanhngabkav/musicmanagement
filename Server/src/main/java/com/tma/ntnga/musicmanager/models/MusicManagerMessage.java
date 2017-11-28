package com.tma.ntnga.musicmanager.models;

import com.tma.ntnga.musicmanager.entities.Song;

public class MusicManagerMessage {

    private MessageStatus status;

    private Song song;

    public MusicManagerMessage() {
    }

    public MusicManagerMessage(MessageStatus status, Song song) {
        this.status = status;
        this.song = song;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MusicManagerMessage that = (MusicManagerMessage) o;

        if (status != that.status) return false;
        return song != null ? song.equals(that.song) : that.song == null;
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (song != null ? song.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MusicManagerMessage{" +
                "status=" + status +
                ", song=" + song.toString() +
                '}';
    }
}
