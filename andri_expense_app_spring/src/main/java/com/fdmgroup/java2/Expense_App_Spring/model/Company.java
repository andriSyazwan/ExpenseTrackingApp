package com.fdmgroup.java2.Expense_App_Spring.model;

import java.util.List;

import org.springframework.stereotype.Component;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "company_id")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int company_id;
	
	@Column(unique=true, nullable=false)
	@NotNull(message = "Company needs to have a name")
	@Size(min = 2, max = 25, message = "Company name needs to be between 2 and 25 characters.")
	private String name;
	
	@NotNull(message = "Company budget cannot be null")
	private double budget;
	
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	@JsonIdentityReference(alwaysAsId = true)
	private List<User> userList;

	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	@JsonIdentityReference(alwaysAsId = true)
	private List<Expense> expenseList;

	// Constructors
	public Company() {
		super();
	}
	
	public Company(String name) {
		super();
		this.name = name;
	}
	// Getters and setters
	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return userList;
	}

	public void setUsers(List<User> users) {
		userList = users;
	}
	
	public List<Expense> getExpenseList() {
		return expenseList;
	}

	public void setExpenseList(List<Expense> expenseList) {
		this.expenseList = expenseList;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	
}