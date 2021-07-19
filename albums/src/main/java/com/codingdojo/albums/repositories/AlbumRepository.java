package com.codingdojo.albums.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.albums.models.Album;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long>{
	List<Album> findAll(); // SELECT * FROM ALBUMS
}
