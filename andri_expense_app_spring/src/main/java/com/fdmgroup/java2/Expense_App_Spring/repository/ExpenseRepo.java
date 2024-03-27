package com.fdmgroup.java2.Expense_App_Spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fdmgroup.java2.Expense_App_Spring.model.Expense;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Integer>{
	List<Expense> findByCompany_Name(String name);
//	List<Expense> findByCompany_company_id(int companyId);
	List<Expense> findByUser_Username(String name);

	@Query("SELECT e FROM Expense e WHERE e.company.name = :name AND YEAR(e.date) = :year")
	List<Expense> findByCompanyAndYear(String name, int year);
}
