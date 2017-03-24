package com.vv.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	@GetMapping(value="/idea/search/vertical/{vertical}",produces="application/json")
	public List<Idea> listIdeasByVertial(@PathVariable String vertical){
		return ideaRepository.getIdeasByVertical(vertical);
	}
	
	@GetMapping("/idea/search/process/{process}")
	public List<Idea> listIdeasByProcess(@PathVariable String process){
		return ideaRepository.getIdeasByProcess(process);
	}
	
	@GetMapping("/idea/search/verprocs/{vertical}/{process}")
	public List<Idea> listIdeasByVertialProcess(@PathVariable String vertical, @PathVariable String process){
		return ideaRepository.getIdeasByVerPrcs(vertical, process);
	}
	
	@GetMapping("/idea/search/soltitle/{soltitle}")
	public List<Idea> listIdeasByVertialProcess(@PathVariable String soltitle){
		return ideaRepository.getIdeasByName(soltitle);
	}
}
