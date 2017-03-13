package com.vv.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.vv.model.Comments;

public interface CommentRepository extends PagingAndSortingRepository<Comments, Long>{
	@Override
	List<Comments> findAll();
	List<Comments> findByProfile_id(Long profile_id);
}
