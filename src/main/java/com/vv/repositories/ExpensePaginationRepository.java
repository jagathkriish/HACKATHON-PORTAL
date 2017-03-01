package com.vv.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.vv.model.Expense;

public interface ExpensePaginationRepository extends PagingAndSortingRepository<Expense, Long> {
	
}
