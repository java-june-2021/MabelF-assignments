package com.codingdojo.albums.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.albums.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	// SELECT * FROM Users is not CRUD so we need to put this in here...
	List<User> findAll();

	boolean existsByEmail(String email);  // Email pertains to the field named the same thing on user.java
	User findByEmail(String email); // Pull out object via email
}
