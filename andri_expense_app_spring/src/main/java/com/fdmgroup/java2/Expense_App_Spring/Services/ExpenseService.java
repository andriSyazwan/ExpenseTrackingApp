package com.fdmgroup.java2.Expense_App_Spring.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.java2.Expense_App_Spring.Exception.ExpenseNotFoundException;
import com.fdmgroup.java2.Expense_App_Spring.model.Expense;
import com.fdmgroup.java2.Expense_App_Spring.repository.ExpenseRepo;



@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepo expenseRepo;
	
	// Method to get all Users
	public List<Expense> findAllExpense() {
		return expenseRepo.findAll();
	}
	
	// Retrieve contact from Id
	public Expense retrieveExpense(int expenseId) throws Exception {
		Optional<Expense> expenseOptional = expenseRepo.findById(expenseId);
		return expenseOptional.orElseThrow(() -> new ExpenseNotFoundException("Expense with ID " + expenseId + " not found"));
	}
	
	
	// Save a new Category from JSON obj
	public Expense saveExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
//	public List<Expense> getCompanyExpenseList(int companyId) {
//		return expenseRepo.findByCompany_company_id(companyId);
//	}

	// Retrieve expenses based on company
	public List<Expense> getNamedCompanyExpenseList(String name) {
		return expenseRepo.findByCompany_Name(name);
	}

	// Retrieve expenses based on user
	public List<Expense> getUserExpenseList(String username) {
		return expenseRepo.findByUser_Username(username);
	}

	// Retrieve expenses based on company and year
	public List<Expense> getExpensesBasedOnCompanyAndYear(String name, int year) { return expenseRepo.findByCompanyAndYear_Name_Year(name, year); }
}