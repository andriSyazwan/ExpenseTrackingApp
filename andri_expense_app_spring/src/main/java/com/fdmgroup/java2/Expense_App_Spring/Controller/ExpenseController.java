package com.fdmgroup.java2.Expense_App_Spring.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fdmgroup.java2.Expense_App_Spring.Services.ExpenseService;
import com.fdmgroup.java2.Expense_App_Spring.model.Expense;


@RestController
@RequestMapping("/api/expense")
@CrossOrigin(origins = "http://localhost:3000")
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	// Get All expenses
	@GetMapping("/all")
	public List<Expense> getAllExpense() {
		return expenseService.findAllExpense();
	}
	
	// Get expense by ID
	@GetMapping("/{id}")
	public Expense getExpenseFromId(@PathVariable("id") int expenseId) throws Exception {
		return expenseService.retrieveExpense(expenseId);
	}
	
	// Get All expense within company only
//	@GetMapping("company/{id}")
//	public List<Expense> getListOfExpensesViaId(@PathVariable("id") int companyId) {
//		return expenseService.getCompanyExpenseList(companyId);
//	}
//	
	@GetMapping("company/{name}")
	public List<Expense> getListOfExpensesViaId(@PathVariable("name") String companyName) {
		return expenseService.getNamedCompanyExpenseList(companyName);
	}
	
	@GetMapping("user/{username}")
	public List<Expense> getListOfExpensesViaUser(@PathVariable("username") String username) {
		return expenseService.getUserExpenseList(username);
	}
	
	@PostMapping
	public ResponseEntity<Expense> saveExpense(@RequestBody Expense expense) {
		Expense savedExpense = expenseService.saveExpense(expense);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedExpense.getExpense_id()).toUri();
		
		return ResponseEntity.created(location).body(savedExpense);
	}
}