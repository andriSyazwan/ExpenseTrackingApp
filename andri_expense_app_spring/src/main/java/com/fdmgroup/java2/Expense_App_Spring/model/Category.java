package com.fdmgroup.java2.Expense_App_Spring.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Component
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "category_id")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int category_id;
	
	@Enumerated(EnumType.STRING)
	private ExpenseCategory name;
	

	@OneToMany(mappedBy = "category")
	@JsonIdentityReference(alwaysAsId = true)
	private List<Expense> expenseList;
	
	// Constructors
	public Category() {
		super();
	}
	
	public Category(ExpenseCategory name) {
		super();
		this.name = name;
	}

	// Getters and Setters
	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_ID) {
		this.category_id = category_ID;
	}

	public ExpenseCategory getName() {
		return name;
	}

	public void setName(ExpenseCategory name) {
		this.name = name;
	}

	public List<Expense> getExpenseList() {
		return expenseList;
	}

	public void setExpenseList(List<Expense> expenseList) {
		this.expenseList = expenseList;
	}
	
	
}
