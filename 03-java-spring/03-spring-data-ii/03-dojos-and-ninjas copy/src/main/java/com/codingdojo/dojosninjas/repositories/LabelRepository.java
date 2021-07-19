package com.codingdojo.dojosninjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojosninjas.models.Label;

@Repository
public interface LabelRepository extends CrudRepository<Label, Long>{

}
