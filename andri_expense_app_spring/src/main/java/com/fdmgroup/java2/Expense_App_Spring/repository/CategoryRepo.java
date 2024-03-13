package com.fdmgroup.java2.Expense_App_Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.java2.Expense_App_Spring.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
