package com.fdmgroup.java2.Expense_App_Spring.model;

import java.util.List;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "user_id")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	@Column(unique=true, nullable=false)
	@NotNull(message = "Username cannot be null")
	@Size(min = 4, max = 16, message = "Username must be between 8 and 16 characters.")
	private String username;
	
	@NotNull(message = "Password cannot be null")
	@Size(min = 8, max = 25, message = "Password must be between 8 and 25 characters.")
	private String password;
	

	@Size(min = 1, max = 16, message = "First Name must be between 1 and 16 characters.")
	private String FirstName;
	

	@Size(min = 1, max = 16, message = "Last Name must be between 1 and 16 characters.")
	private String LastName;
	
	@ManyToOne
	@JoinColumn(name = "company_ID")
	@JsonIdentityReference(alwaysAsId = true)
	private Company company;

	// Constructors
	public User() {
		super();
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
	// Getters and setters
	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	
	
	
}