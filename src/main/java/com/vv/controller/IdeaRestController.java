package com.vv.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vv.model.Idea;
import com.vv.repositories.IdeaRepository;

@RestController
public class IdeaRestController {
	private IdeaRepository ideaRepository;
	public IdeaRestController(IdeaRepository ideaRepository){
		this.ideaRepository = ideaRepository;
	}
	
	@GetMapping("/ideas")
	public List<Idea> expList(){
		return this.ideaRepository.findAll();
	}
	
	@GetMapping("/ideaPages")
	Page<Idea> listAllByPage(Pageable pageable) {
		return ideaRepository.findAll(pageable);
	}
	
	@GetMapping("/ideaFiles")
	List<Object> listIdeaFilesByPage(Pageable pageable) {
		return ideaRepository.getIdeaFiles(pageable);
	}
}
