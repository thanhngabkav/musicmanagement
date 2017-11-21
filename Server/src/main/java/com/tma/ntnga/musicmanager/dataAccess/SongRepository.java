/**
 * Interface : SongRepository
 * Version : 1.0
 */

package com.tma.ntnga.musicmanager.dataAccess;

import com.tma.ntnga.musicmanager.entities.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song,Integer> {
}
