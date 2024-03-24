package com.fdmgroup.java2.Expense_App_Spring;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

@Component
public class AppRunner implements ApplicationRunner{

	private UserRepo userRepoTest;
	private CategoryRepo catRepoTest;
	private CompanyRepo coyRepoTest;
	private ExpenseRepo expRepoTest;



	@Autowired
	public AppRunner(UserRepo userRepoTest, CategoryRepo catRepoTest, CompanyRepo coyRepoTest, ExpenseRepo expRepoTest) {
		this.userRepoTest = userRepoTest;
		this.catRepoTest = catRepoTest;
		this.coyRepoTest = coyRepoTest;
		this.expRepoTest = expRepoTest;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		// Create user objects
		User userTest1 = new User("Admin1", "Password1");
		User userTest2 = new User("Admin2", "Password2");
		User userTest3 = new User("Admin3", "Password3");
		User userTest4 = new User("Admin4", "Password4");
		User userTest5 = new User("Admin5", "Password5");
		User userTest6 = new User("Admin6", "Password6");
		User userTest7 = new User("Admin7", "Password7");
		User userTest8 = new User("Admin8", "Password8");
		User userTest9 = new User("Admin9", "Password9");
		User userTest10 = new User("Admin10", "Password10");
		User userTest11 = new User("Admin11", "Password11");
		User userTest12 = new User("Admin12", "Password12");
		User userTest13 = new User("Admin13", "Password13");
		User userTest14 = new User("Admin14", "Password14");
		User userTest15 = new User("Admin15", "Password15");
		User userTestToBeDeleted = new User("ToBeDeleted", "Password");

		// Creating company objects
		Company coyTest1 = new Company("Caltech");
		Company coyTest2 = new Company("Plank Co");
		Company coyTest3 = new Company("Pearson Hardman");
		Company coyTest4 = new Company("Simon Co");
		Company coyTest5 = new Company("OpenAI");

		// Making the all the listed category objects
		Category Marketing = new Category(ExpenseCategory.Marketing);
		Category OfficeSupplies = new Category(ExpenseCategory.OfficeSupplies);
		Category Charity = new Category(ExpenseCategory.Charity);
		Category ClientServices = new Category(ExpenseCategory.ClientServices);
		Category EmployeeBenefits = new Category(ExpenseCategory.EmployeeBenefits);
		Category Entertainment = new Category(ExpenseCategory.Entertainement);
		Category Insurance = new Category(ExpenseCategory.Insurance);
		Category Miscellaneous = new Category(ExpenseCategory.Miscellaneous);
		Category Rent = new Category(ExpenseCategory.Rent);
		Category Salaries = new Category(ExpenseCategory.Salaries);
		Category Software = new Category(ExpenseCategory.Software);
		Category Training = new Category(ExpenseCategory.Training);
		Category Travel = new Category(ExpenseCategory.Travel);
		Category Utilities = new Category(ExpenseCategory.Utilities);

		// Needed to mock dates in the Expense constructor
		SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");

		// Creating expense objects
		Expense expTest1 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest1, Marketing);
		Expense expTest2 = new Expense(554.40, false, date.parse("01-02-2023"), userTest1, Travel);
		Expense expTest3 = new Expense(1211.30, true, date.parse("01-03-2023"), userTest1, Training);
		Expense expTest46 = new Expense(1200.0, true, date.parse("01-04-2023"), userTest1, Marketing);
		Expense expTest47 = new Expense(554.40, false, date.parse("01-05-2023"), userTest1, Travel);
		Expense expTest48 = new Expense(1211.30, true, date.parse("01-06-2023"), userTest1, Training);
		Expense expTest49 = new Expense(554.40, false, date.parse("01-07-2023"), userTest1, Travel);
		Expense expTest50 = new Expense(1211.30, true, date.parse("01-08-2023"), userTest1, Training);
		Expense expTest51 = new Expense(1200.0, true, date.parse("01-08-2023"), userTest1, Marketing);
		Expense expTest52 = new Expense(554.40, false, date.parse("01-09-2023"), userTest1, Travel);
		Expense expTest53 = new Expense(1211.30, true, date.parse("01-10-2023"), userTest1, Training);
		Expense expTest54 = new Expense(554.40, false, date.parse("01-05-2023"), userTest1, Travel);
		Expense expTest55 = new Expense(1211.30, true, date.parse("01-06-2023"), userTest1, Training);
		Expense expTest56 = new Expense(554.40, false, date.parse("01-07-2023"), userTest1, Travel);
		Expense expTest57 = new Expense(1211.30, true, date.parse("01-08-2023"), userTest1, Training);
		Expense expTest58 = new Expense(1200.0, true, date.parse("01-08-2023"), userTest1, Marketing);
		Expense expTest59 = new Expense(554.40, false, date.parse("01-09-2023"), userTest1, Travel);
		Expense expTest60 = new Expense(554.40, false, date.parse("01-09-2023"), userTest1, Travel);

		Expense expTest4 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest2, Marketing);
		Expense expTest5 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest2, Marketing);
		Expense expTest6 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest3, Marketing);

		Expense expTest10 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest3, Marketing);
		Expense expTest11 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest3, Marketing);
		Expense expTest12 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest3, Marketing);

		Expense expTest13 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest4, Marketing);
		Expense expTest14 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest4, Marketing);
		Expense expTest15 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest4, Marketing);

		Expense expTest16 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest5, Marketing);
		Expense expTest17 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest5, Marketing);
		Expense expTest18 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest5, Marketing);

		Expense expTest19 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest6, Marketing);
		Expense expTest20 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest6, Marketing);
		Expense expTest21 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest6, Marketing);

		Expense expTest22 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest7, Marketing);
		Expense expTest23 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest7, Marketing);
		Expense expTest24 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest7, Marketing);

		Expense expTest25 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest8, Marketing);
		Expense expTest26 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest8, Marketing);
		Expense expTest27 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest8, Marketing);

		Expense expTest28 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest9, Marketing);
		Expense expTest29 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest9, Marketing);
		Expense expTest30 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest9, Marketing);

		Expense expTest7 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest10, Marketing);
		Expense expTest8 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest10, Marketing);
		Expense expTest9 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest10, Marketing);

		Expense expTest31 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest11, Marketing);
		Expense expTest32 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest11, Marketing);
		Expense expTest33 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest11, Marketing);

		Expense expTest34 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest12, Marketing);
		Expense expTest35 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest12, Marketing);
		Expense expTest36 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest12, Marketing);

		Expense expTest37 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest13, Marketing);
		Expense expTest38 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest13, Marketing);
		Expense expTest39 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest13, Marketing);

		Expense expTest40 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest14, Marketing);
		Expense expTest41 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest14, Marketing);
		Expense expTest42 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest14, Marketing);

		Expense expTest43 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest15, Marketing);
		Expense expTest44 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest15, Marketing);
		Expense expTest45 = new Expense(1200.0, true, date.parse("01-01-2023"), userTest15, Marketing);

		// Save all companies
		coyRepoTest.save(coyTest1);
		coyRepoTest.save(coyTest2);
		coyRepoTest.save(coyTest3);
		coyRepoTest.save(coyTest4);
		coyRepoTest.save(coyTest5);

		// Specify Company for each user
		userTest1.setCompany(coyTest1);
		userTest2.setCompany(coyTest1);
		userTest3.setCompany(coyTest1);
		userTest4.setCompany(coyTest2);
		userTest5.setCompany(coyTest2);
		userTest6.setCompany(coyTest2);
		userTest7.setCompany(coyTest3);
		userTest8.setCompany(coyTest3);
		userTest9.setCompany(coyTest3);
		userTest10.setCompany(coyTest4);
		userTest11.setCompany(coyTest4);
		userTest12.setCompany(coyTest4);
		userTest13.setCompany(coyTest5);
		userTest14.setCompany(coyTest5);
		userTest15.setCompany(coyTest5);

		// Save all users
		userRepoTest.save(userTest1);
		userRepoTest.save(userTest2);
		userRepoTest.save(userTest3);
		userRepoTest.save(userTest4);
		userRepoTest.save(userTest5);
		userRepoTest.save(userTest6);
		userRepoTest.save(userTest7);
		userRepoTest.save(userTest8);
		userRepoTest.save(userTest9);
		userRepoTest.save(userTest10);
		userRepoTest.save(userTest11);
		userRepoTest.save(userTest12);
		userRepoTest.save(userTest13);
		userRepoTest.save(userTest14);
		userRepoTest.save(userTest15);
		userRepoTest.save(userTestToBeDeleted);

		// Save all categories
		catRepoTest.save(Marketing);
		catRepoTest.save(OfficeSupplies);
		catRepoTest.save(Charity);
		catRepoTest.save(ClientServices);
		catRepoTest.save(EmployeeBenefits);
		catRepoTest.save(Entertainment);
		catRepoTest.save(Insurance);
		catRepoTest.save(Miscellaneous);
		catRepoTest.save(Rent);
		catRepoTest.save(Salaries);
		catRepoTest.save(Software);
		catRepoTest.save(Training);
		catRepoTest.save(Travel);
		catRepoTest.save(Utilities);

		// Save all expenses
		expRepoTest.save(expTest1);
		expRepoTest.save(expTest2);
		expRepoTest.save(expTest3);
		expRepoTest.save(expTest4);
		expRepoTest.save(expTest5);
		expRepoTest.save(expTest6);
		expRepoTest.save(expTest7);
		expRepoTest.save(expTest8);
		expRepoTest.save(expTest9);
		expRepoTest.save(expTest10);
		expRepoTest.save(expTest11);
		expRepoTest.save(expTest12);
		expRepoTest.save(expTest13);
		expRepoTest.save(expTest14);
		expRepoTest.save(expTest15);
		expRepoTest.save(expTest16);
		expRepoTest.save(expTest17);
		expRepoTest.save(expTest18);
		expRepoTest.save(expTest19);
		expRepoTest.save(expTest20);
		expRepoTest.save(expTest21);
		expRepoTest.save(expTest22);
		expRepoTest.save(expTest23);
		expRepoTest.save(expTest24);
		expRepoTest.save(expTest25);
		expRepoTest.save(expTest26);
		expRepoTest.save(expTest27);
		expRepoTest.save(expTest28);
		expRepoTest.save(expTest29);
		expRepoTest.save(expTest30);
		expRepoTest.save(expTest31);
		expRepoTest.save(expTest32);
		expRepoTest.save(expTest33);
		expRepoTest.save(expTest34);
		expRepoTest.save(expTest35);
		expRepoTest.save(expTest36);
		expRepoTest.save(expTest37);
		expRepoTest.save(expTest38);
		expRepoTest.save(expTest39);
		expRepoTest.save(expTest40);
		expRepoTest.save(expTest41);
		expRepoTest.save(expTest42);
		expRepoTest.save(expTest43);
		expRepoTest.save(expTest44);
		expRepoTest.save(expTest45);
		expRepoTest.save(expTest46);
		expRepoTest.save(expTest47);
		expRepoTest.save(expTest48);
		expRepoTest.save(expTest49);
		expRepoTest.save(expTest50);
		expRepoTest.save(expTest51);
		expRepoTest.save(expTest52);
		expRepoTest.save(expTest53);
		expRepoTest.save(expTest54);
		expRepoTest.save(expTest55);
		expRepoTest.save(expTest56);
		expRepoTest.save(expTest57);
		expRepoTest.save(expTest58);
		expRepoTest.save(expTest59);
		expRepoTest.save(expTest60);

		// Testing Delete
		userRepoTest.deleteById((int) userRepoTest.findByUsername("ToBeDeleted").get().getUser_id());

		// Test getAll and print in console
		for (Company company : coyRepoTest.findAll()) {
			System.out.println(company.getName());
		}
		System.out.println("If you see this in the console, it means everything went smoothly");

	}

}
