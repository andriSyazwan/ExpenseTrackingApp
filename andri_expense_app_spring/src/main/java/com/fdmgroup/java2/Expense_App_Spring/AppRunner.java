package com.fdmgroup.java2.Expense_App_Spring;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.fdmgroup.java2.Expense_App_Spring.model.Category;
import com.fdmgroup.java2.Expense_App_Spring.model.Company;
import com.fdmgroup.java2.Expense_App_Spring.model.Expense;
import com.fdmgroup.java2.Expense_App_Spring.model.ExpenseCategory;
import com.fdmgroup.java2.Expense_App_Spring.model.User;
import com.fdmgroup.java2.Expense_App_Spring.repository.CategoryRepo;
import com.fdmgroup.java2.Expense_App_Spring.repository.CompanyRepo;
import com.fdmgroup.java2.Expense_App_Spring.repository.ExpenseRepo;
import com.fdmgroup.java2.Expense_App_Spring.repository.UserRepo;

//@Component
//public class AppRunner implements ApplicationRunner{
//
//	private UserRepo userRepoTest;
//	private CategoryRepo catRepoTest;
//	private CompanyRepo coyRepoTest;
//	private ExpenseRepo expRepoTest;
//	
//	@Autowired
//	public AppRunner(UserRepo userRepoTest, CategoryRepo catRepoTest, CompanyRepo coyRepoTest, ExpenseRepo expRepoTest) {
//		this.userRepoTest = userRepoTest;
//		this.catRepoTest = catRepoTest;
//		this.coyRepoTest = coyRepoTest;
//		this.expRepoTest = expRepoTest;
//	}
//	
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		
//		// Create
//		User userTest1 = new User("Frank", "Password1");
//		User userTest2 = new User("Feynman", "technique");
//		User userTest3 = new User("Nicolo", "SashaLovesFood");
//		User userTest4 = new User("Onyakopon", "HanjiIchiban");
//		User userTest5 = new User("Donna", "HarveySuits");
//		
//		Company coyTest1 = new Company("Caltech");
//		Company coyTest2 = new Company("TeamEren");
//		Company coyTest3 = new Company("Pearson Hardman");
//		
//		Expense expTest1 = new Expense(120.0, true, new Date());
//		Expense expTest2 = new Expense(300.0, false, new Date());
//		Expense expTest3 = new Expense(522.44, true, new Date());
//		
//		Category catTest1 = new Category(ExpenseCategory.Marketing);
//		Category catTest2 = new Category(ExpenseCategory.OfficeSupplies);
//		
//		// Test Saving
//		userRepoTest.save(userTest1);
//		userRepoTest.save(userTest2);
//		userRepoTest.save(userTest3);
//		userRepoTest.save(userTest4);
//		userRepoTest.save(userTest5);
//
//		coyRepoTest.save(coyTest1);
//		coyRepoTest.save(coyTest2);
//		coyRepoTest.save(coyTest3);
//		
//		expRepoTest.save(expTest1);
//		expRepoTest.save(expTest2);
//		expRepoTest.save(expTest3);
//		
//		catRepoTest.save(catTest1);
//		catRepoTest.save(catTest2);
//		
//		// Specify Company for each object
//		userTest1.setCompany(coyTest1);
//		userTest2.setCompany(coyTest1);
//		userTest3.setCompany(coyTest2);
//		userTest4.setCompany(coyTest2);
//		userTest5.setCompany(coyTest2);
//		
//		// Specify every id for expense
//		expTest1.setCategory(catTest2);
//		expTest1.setUser(userTest3);
//		expTest1.setCompany(coyTest1);
//		expTest2.setCategory(catTest1);
//		expTest2.setUser(userTest1);
//		expTest2.setCompany(coyTest2);
//		expTest3.setCategory(catTest1);
//		expTest3.setUser(userTest1);
//		expTest3.setCompany(coyTest1);
//		
//		// Update to database
//		userRepoTest.save(userTest1);
//		userRepoTest.save(userTest2);
//		userRepoTest.save(userTest3);
//		userRepoTest.save(userTest4);
//		userRepoTest.save(userTest5);
//		
//		expRepoTest.save(expTest1);
//		expRepoTest.save(expTest2);
//		expRepoTest.save(expTest3);
//		
//		
//		// Read(Should print out "technique"
//		System.out.println("\n"+userRepoTest.findByUsername("Feynman").get().getPassword());
//		System.out.println(userRepoTest.findByUsername("Donna").get().getPassword()+"\n");
//	
//		// Test Update
//		userTest1.setPassword("MikeWasPOG");
//		userRepoTest.save(userTest1);
//		System.out.println(userRepoTest.findByUsername("Donna").get().getPassword()+"\n");
//		
//		// Delete
//		userRepoTest.deleteById((int) userRepoTest.findByUsername("Feynman").get().getUser_id());
//		
//		// Test getAll
//		for (Expense expense : expRepoTest.findAll()) {
//			System.out.println(expense.getExpense_id()); 
//			System.out.println(expense.getAmount());
//			System.out.println(expense.getCompany().getName() + "\n");
//		}
//		System.out.println("If you see this in the console, it means everything went smoothly");
//		
//	}
//
//}
