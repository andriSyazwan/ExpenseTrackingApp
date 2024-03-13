package com.fdmgroup.java2.Expense_App_Spring.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Component
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "expense_id")
public class Expense {
	// Self Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int expense_id;
	
	@Min(value = 0, message = "Amount must be a positive number")
	private double amount;
	
	@NotNull(message = "Expense status cannot be null")
	private boolean status;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private String description;
	

	// Mapped attributes
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_ID")
	@JsonIdentityReference(alwaysAsId = true)
	@NotNull(message = "Must have user to key in expense")
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "company_ID")
	@JsonIdentityReference(alwaysAsId = true)
	@NotNull(message = "Expense must be company registered")
	private Company company;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_ID")
	@JsonIdentityReference(alwaysAsId = true)
	@NotNull(message = "Expense must have a category")
	private Category category;
	
	// Constructors
	public Expense() {
		super();
	}
	
	public Expense(double amount, boolean status, Date date) {
		super();
		this.amount = amount;
		this.status = status;
		this.date = date;
	}

	// Getters and setters
	public int getExpense_id() {
		return expense_id;
	}

	public void setExpense_ID(int expense_ID) {
		this.expense_id = expense_ID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
