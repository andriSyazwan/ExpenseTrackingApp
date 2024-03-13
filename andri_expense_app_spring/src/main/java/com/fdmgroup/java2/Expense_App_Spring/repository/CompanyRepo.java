package com.fdmgroup.java2.Expense_App_Spring.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.java2.Expense_App_Spring.model.Company;



@Repository
public interface CompanyRepo extends JpaRepository<Company, Integer>{
	Optional<Company> findByName(String name);

}
