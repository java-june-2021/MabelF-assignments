package com.codingdojo.albums.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.albums.models.User;
import com.codingdojo.albums.repositories.UserRepository;

@Service
public class UserService {
	@Autowired 
	private UserRepository uRepo;
	
	// List of all users for dropdown menu
	public List<User> allUsers() {
		return this.uRepo.findAll();
	}
	
	public User findOneUser(Long id) {
		// Use crud to grab it from the database
		User user = this.uRepo.findById(id).orElse(null); // This returns an optional
		return user;
	}
	
	
	// LOGIN + REGISTRATION
	public User registerUser(User user) {
		// Generate Hash
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()); // Intercept from the front end, as many rounds of salt as you want
		
		// Set the hashed password on the users password field
		user.setPassword(hash);
		
		// Save new password to database
		return this.uRepo.save(user);
	}
	
	public boolean authenticateUser(String email, String password) {
		User user = this.uRepo.findByEmail(email);
		
		if (user==null) {
			return false;
		}
		
		return BCrypt.checkpw(password, user.getPassword());
	}
	
	public User getByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
	

}
