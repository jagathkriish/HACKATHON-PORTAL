package com.vv.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vv.model.Comments;
import com.vv.model.Profile;
import com.vv.repositories.CommentRepository;
import com.vv.repositories.ProfileRepository;

@RestController
public class CommentRestController {
	private CommentRepository commentRepository;
	private ProfileRepository profileRepository;
	public CommentRestController(CommentRepository commentRepository,ProfileRepository profileRepository){
		this.commentRepository = commentRepository;
		this.profileRepository = profileRepository;
	}
	
	@GetMapping("/comments")
	public List<Comments> cmtList(){
		return this.commentRepository.findAll();
	}
	
	@GetMapping("/comments/{capId}")
	public List<Comments> cmtIdList(@PathVariable String capId){
		Profile profile = profileRepository.findOneByCapId(capId);
		return this.commentRepository.findByProfile_id(profile.getId());
	}
	
	
}
