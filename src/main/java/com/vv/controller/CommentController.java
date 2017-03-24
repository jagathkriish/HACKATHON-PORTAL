package com.vv.controller;

import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vv.model.Comments;
import com.vv.model.Idea;
import com.vv.repositories.CommentRepository;
import com.vv.repositories.IdeaRepository;
import com.vv.repositories.ProfileRepository;

@Controller
public class CommentController {
	private final Logger log = LoggerFactory.getLogger(IdeaContoller.class);
	private CommentRepository commentsRepository;
	private IdeaRepository ideaRepository;

	public CommentController(CommentRepository commentsRepository, IdeaRepository ideaRepository,
			ProfileRepository profileRepository) {
		this.commentsRepository = commentsRepository;
		this.ideaRepository = ideaRepository;
	}

	@PostMapping(value = "/commentIdea")
	public ResponseEntity<?> commentIdea(@RequestParam Long ideaId, @RequestParam String comment,
			@RequestParam String commentedBy) {
		try {
			Idea idea = ideaRepository.findOneById(ideaId);
			Stream<Comments> comments = Stream.of(new Comments(idea, comment, commentedBy.concat("@capgemini.com")));
			comments.forEach(commentsRepository::save);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
			return ResponseEntity.status(HttpStatus.OK).body(null);
	}

}
