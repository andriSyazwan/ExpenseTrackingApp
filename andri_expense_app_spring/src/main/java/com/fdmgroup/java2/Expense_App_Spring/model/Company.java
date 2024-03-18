package com.fdmgroup.java2.Expense_App_Spring.model;

import java.util.List;

import org.springframework.stereotype.Component;

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
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int company_id;
	
	@Column(unique=true, nullable=false)
	@NotNull(message = "Company needs to have a name")
	@Size(min = 2, max = 25, message = "Company name needs to be between 2 and 25 characters.")
	private String name;

	private double budget;


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


	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	
}