package com.fdmgroup.java2.Expense_App_Spring.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.java2.Expense_App_Spring.Exception.UserNotFoundException;
import com.fdmgroup.java2.Expense_App_Spring.model.User;
import com.fdmgroup.java2.Expense_App_Spring.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	// Method to get all Users
	public List<User> findAllUsers() {
		return userRepo.findAll();
	}
	
	// Retrieve user from Id
	public User retrieveUser(int userId) throws Exception {
		Optional<User> userOptional = userRepo.findById(userId);
		return userOptional.orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found"));
	}
	
	// Retrieve user from Username
	public User retrieveUserFromUN(String username) throws Exception {
		Optional<User> userOptional = userRepo.findByUsername(username);
		return userOptional.orElseThrow(() -> new UserNotFoundException("User with Username " + username + " not found"));
	}
	
	// Save a new User to DB from JSON obj
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	// Method to delete User
	// Save a new User to DB from JSON obj
	public void deleteUser(User user) {
		userRepo.delete(user);
	}
	
	public void deleteByUserId(int userId) {
		userRepo.deleteById(userId);
	}
	
    public User loginUser(String username, String password) throws UserNotFoundException {
        User user = userRepo.findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new UserNotFoundException("Invalid username or password"));
        return user;
    }
	
	// Update Password for username
	public User updatePassword(String username, User updatedUser) throws Exception {

		// get the desired object
        User existingUser = this.retrieveUserFromUN(username);
        
        // Update only the password
        existingUser.setPassword(updatedUser.getPassword());

        // Save the updated user
        User savedUser = this.saveUser(existingUser);
        
        return savedUser;
	}
	
}
