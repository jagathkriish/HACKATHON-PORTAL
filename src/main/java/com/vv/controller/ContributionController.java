package com.vv.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vv.model.Contributions;
import com.vv.model.Idea;
import com.vv.repositories.ContributeRepository;
import com.vv.repositories.IdeaRepository;

@Controller
public class ContributionController {
	private final Logger log = LoggerFactory.getLogger(IdeaContoller.class);
	private ContributeRepository contributionRepository;
	private IdeaRepository ideaRepository;
	
	public ContributionController(ContributeRepository contributionRepository, IdeaRepository ideaRepository) {
		super();
		this.contributionRepository = contributionRepository;
		this.ideaRepository = ideaRepository;
	}
	
	@PostMapping(value = "/contribute", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> contributeIdea(@RequestBody HashMap<String,List<String>> data) {
		Idea idea = ideaRepository.findOneById(Long.parseLong(data.get("team").get(0)));
		List<Contributions> contribList = new ArrayList<Contributions>();
		for(int i=1;i<=data.size()-1;i++){
			contribList.add(new Contributions(idea, data.get("team").get(1),Byte.valueOf(data.get("team").get(2)),data.get("member"+i).get(0),data.get("member"+i).get(1),data.get("member"+i).get(2),data.get("member"+i).get(3),data.get("member"+i).get(4).charAt(0)));
		}
		Stream<Contributions> contributions = contribList.stream();
		try{
		contributions.forEach(contributionRepository::save);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
			return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	
}
