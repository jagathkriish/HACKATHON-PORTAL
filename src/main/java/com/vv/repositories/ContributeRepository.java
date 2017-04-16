package com.vv.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.vv.model.Contributions;

public interface ContributeRepository extends PagingAndSortingRepository<Contributions, Long> {
	@Override
	List<Contributions> findAll();
	List<Contributions> findByideaId(Long idea_id);
}
