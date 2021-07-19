package com.codingdojo.albums.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.albums.models.Label;

@Repository
public interface LabelRepository extends CrudRepository<Label, Long>{

}
