package com.vv.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.vv.model.Idea;
import com.vv.model.Profile;

public interface IdeaRepository extends PagingAndSortingRepository<Idea, Long>{
	@Override
	List<Idea> findAll();
	@Query("SELECT documentName,videoName from Idea")
	List<Object> getIdeaFiles(Pageable pageable);
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Idea set rating = ?1, status = ?2 where profile_Id = ?3")
	int rateIdea(float rating,String status, Long id);
}
