package com.fdmgroup.java2.Expense_App_Spring.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fdmgroup.java2.Expense_App_Spring.Services.CompanyService;
import com.fdmgroup.java2.Expense_App_Spring.model.Company;



@RestController
@RequestMapping("/api/companies")
@CrossOrigin(origins = "http://localhost:3000")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	// Get All companies
	@GetMapping("/all")
	public List<Company> getAllCompanies() {
		return companyService.findAllCompanies();
	}
	
	// Get company by ID
	@GetMapping("/{id}")
	public Company getCompanyFromId(@PathVariable("id") int companyId) throws Exception {
		return companyService.retrieveCompany(companyId);
	}
	
	// Get company by Name
	@GetMapping("name/{name}")
	public Company getCompanyFromName(@PathVariable("name") String companyName) throws Exception {
		return companyService.retrieveCompanyFromN(companyName);
	}
	
	
	@PostMapping
	public ResponseEntity<Company> saveCompany(@RequestBody Company company) {
		Company savedCompany = companyService.saveCompany(company);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCompany.getCompany_id()).toUri();
		
		return ResponseEntity.created(location).body(savedCompany);
	}
	
	@PatchMapping("/{name}/update-budget")
	public ResponseEntity<Company> updateCompanyBudget(@PathVariable("name") String name, @RequestBody Company updatedCompany) throws Exception {
	    return ResponseEntity.ok(companyService.updateBudget(name, updatedCompany));
	}


	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteCompanyById(@PathVariable("id") int companyId) throws Exception {
		companyService.deleteByCompanyId(companyId);
		return ResponseEntity.noContent().build();
	}
}