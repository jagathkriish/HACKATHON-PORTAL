package com.vv.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vv.model.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long>{
	List<Expense> findByExpenseName(String expname);
	List<Expense> findByExpenseNameAndExpenseAmount(String expname,int amt);
	List<Expense> findByExpenseNameOrExpenseAmount(String expname,int amt);
	@Override
	List<Expense> findAll();
}