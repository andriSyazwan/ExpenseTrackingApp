package com.fdmgroup.java2.Expense_App_Spring.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fdmgroup.java2.Expense_App_Spring.Exception.UserNotFoundException;
import com.fdmgroup.java2.Expense_App_Spring.Services.UserService;
import com.fdmgroup.java2.Expense_App_Spring.model.User;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// Get All users
	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.findAllUsers();
	}
	
	// Get user by ID
	@GetMapping("/{id}")
	public User getUserFromId(@PathVariable("id") int userId) throws Exception {
		return userService.retrieveUser(userId);
	}
	
	// Get user by username
	@GetMapping("/username/{username}")
	public User getUserFromUN(@PathVariable("username") String username) throws Exception {
		return userService.retrieveUserFromUN(username);
	}
	
	// For validating password and username
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        try {
            User loggedInUser = userService.loginUser(user.getUsername(), user.getPassword());
            return ResponseEntity.ok(loggedInUser);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(401).body(null); // Unauthorized status for failed login
        }
    }
	
	
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User savedUser = userService.saveUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getUser_id()).toUri();
		
		return ResponseEntity.created(location).body(savedUser);
	}
	
	@PatchMapping("/{username}/update-password")
	public ResponseEntity<User> updateUserPassword(@PathVariable("username") String username, @RequestBody User updatedUser) throws Exception {
	    return ResponseEntity.ok(userService.updatePassword(username, updatedUser));
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable("id") int userId) throws Exception{
		userService.deleteByUserId(userId);
		return ResponseEntity.noContent().build();
	}
}
