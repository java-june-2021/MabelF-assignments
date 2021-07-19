package com.codingdojo.albums.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.albums.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
	

}
