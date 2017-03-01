package com.vv.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vv.model.Expense;
import com.vv.repositories.ExpenseRepository;

@RestController
public class ExpenseRestController {
	private ExpenseRepository expenseRepository;

	public ExpenseRestController(ExpenseRepository expenseRepository) {
		super();
		this.expenseRepository = expenseRepository;
	}
	
	@GetMapping("/expenses/{expname}")
	public List<Expense> expNameList(Model model,@PathVariable String expname){
		return this.expenseRepository.findByExpenseName(expname);
	}
	
	@GetMapping("/expenses/{expname}/{expAmt}")
	public List<Expense> expNameAndExplainList(Model model,@PathVariable String expname,@PathVariable int expAmt){
		return this.expenseRepository.findByExpenseNameAndExpenseAmount(expname, expAmt);
	}
	
	@GetMapping("/expenses")
	public List<Expense> expList(){
		return this.expenseRepository.findAll();
	}
	
}
