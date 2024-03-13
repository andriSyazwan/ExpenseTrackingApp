package com.fdmgroup.java2.Expense_App_Spring.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.java2.Expense_App_Spring.Exception.CategoryNotFoundException;
import com.fdmgroup.java2.Expense_App_Spring.model.Category;
import com.fdmgroup.java2.Expense_App_Spring.repository.CategoryRepo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	// Method to get all Users
	public List<Category> findAllCategories() {
		return categoryRepo.findAll();
	}
	
	// Retrieve category from Id
	public Category retrieveCategory(int categoryId) throws Exception {
		Optional<Category> categoryOptional = categoryRepo.findById(categoryId);
		return categoryOptional.orElseThrow(() -> new CategoryNotFoundException("Category with ID " + categoryId + " not found"));
	}
	
	
	// Save a new Category from JSON obj
	public Category saveCategory(Category category) {
		return categoryRepo.save(category);
	}
	
}
