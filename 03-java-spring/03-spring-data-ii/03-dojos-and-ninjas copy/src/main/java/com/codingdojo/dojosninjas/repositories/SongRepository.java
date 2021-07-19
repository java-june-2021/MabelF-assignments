package com.codingdojo.dojosninjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojosninjas.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
	

}
