package com.vv.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.vv.model.Profile;

public interface ProfileRepository extends PagingAndSortingRepository<Profile, Long> {
	@Override
	List<Profile> findAll();
	Profile findOneByCapId(String capId);
}
