package com.vv.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vv.model.Comments;
import com.vv.model.Idea;
import com.vv.repositories.CommentRepository;
import com.vv.repositories.IdeaRepository;

@RestController
public class CommentRestController {
	private CommentRepository commentRepository;
	private IdeaRepository ideaRepository;
	public CommentRestController(CommentRepository commentRepository,IdeaRepository ideaRepository){
		this.commentRepository = commentRepository;
		this.ideaRepository = ideaRepository;
	}
	
	@GetMapping("/comments")
	public List<Comments> cmtList(){
		return this.commentRepository.findAll();
	}
	
	@GetMapping("/comments/{ideaId}")
	public List<Comments> cmtsByIdeaId(@PathVariable String ideaId){
		Idea idea = ideaRepository.findOneById(Long.parseLong(ideaId));
		return this.commentRepository.findByideaId(idea.getId());
	}
	
	
}
