package com.fdmgroup.java2.Expense_App_Spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.java2.Expense_App_Spring.Services.CategoryService;
import com.fdmgroup.java2.Expense_App_Spring.model.Category;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

	@Autowired
	private CategoryService catService;
	
	// Get all categories
	@GetMapping("/all")
	public List<Category> getAllCategories() {
		return catService.findAllCategories();
	}
	
	// Get by category ID
	@GetMapping("/{id}")
	public Category getCategoryFromId(@PathVariable("id") int categoryId) throws Exception {
		return catService.retrieveCategory(categoryId);
	}
}
