package com.codingdojo.albums.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.codingdojo.albums.models.User;
import com.codingdojo.albums.repositories.UserRepository;

@Component
public class UserValidator {
	@Autowired
	private UserRepository uRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("password", "Match", "Yikes passwords do not match"); // Path, name, display
		}
		
		if (this.uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "Match", "Yikes, email already registered");
		}
	}

}

