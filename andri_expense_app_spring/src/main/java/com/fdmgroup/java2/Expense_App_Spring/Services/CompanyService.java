package com.fdmgroup.java2.Expense_App_Spring.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.java2.Expense_App_Spring.Exception.CompanyNotFoundException;
import com.fdmgroup.java2.Expense_App_Spring.model.Company;
import com.fdmgroup.java2.Expense_App_Spring.repository.CompanyRepo;


@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepo companyRepo;
	
	// Method to get all Users
	public List<Company> findAllCompanies() {
		return companyRepo.findAll();
	}
	

	
	// Retrieve company from Id
	public Company retrieveCompany(int companyId) throws Exception {
		Optional<Company> companyOptional = companyRepo.findById(companyId);
		return companyOptional.orElseThrow(() -> new CompanyNotFoundException("Company with ID " + companyId + " not found"));
	}
	
	// Retrieve company from Name
	public Company retrieveCompanyFromN(String name) throws Exception {
		Optional<Company> companyOptional = companyRepo.findByName(name);
		return companyOptional.orElseThrow(() -> new CompanyNotFoundException("Company with Name " + name + " not found"));
	}

	
	// Save a new Category from JSON obj
	public Company saveCompany(Company company) {
		return companyRepo.save(company);
	}
	
	// Delete company object
	public void deleteCompany(Company company) {
		companyRepo.delete(company);
	}
	
	// Delete company by ID
	public void deleteByCompanyId(int companyId) {
		companyRepo.deleteById(null);
	}
	
	// Update budget 
	public Company updateBudget(String name, Company updatedCompany) throws Exception {
		// Get desired Company
		Company existingCompany = this.retrieveCompanyFromN(name);
		
		// Set new budget
		existingCompany.setBudget(updatedCompany.getBudget());
		
		// Save existing company
		Company savedCompany = this.saveCompany(existingCompany);
		
		return savedCompany;
	}
	
	// Add delete service method
	
}

