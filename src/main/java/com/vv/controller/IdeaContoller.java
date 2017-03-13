package com.vv.controller;

import java.util.stream.Stream;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vv.model.Idea;
import com.vv.model.IdeaValidator;
import com.vv.model.Profile;
import com.vv.repositories.IdeaRepository;
import com.vv.repositories.ProfileRepository;
import com.vv.service.StorageService;
import com.vv.utils.FileNameBuilder;
import com.vv.validator.IdeaFileValidator;

@Controller
public class IdeaContoller {
	private final Logger log = LoggerFactory.getLogger(IdeaContoller.class);
	private StorageService storageService;
	private IdeaRepository ideaRepository;
	private ProfileRepository profileRepository;
	
	public IdeaContoller(StorageService storageService, IdeaRepository ideaRepository,ProfileRepository profileRepository) {
		this.storageService = storageService;
		this.ideaRepository = ideaRepository;
		this.profileRepository = profileRepository;
	}
	
	@Autowired
	private IdeaFileValidator ideaFileValidator;
	
	@InitBinder
	protected void initBinder(final WebDataBinder binder) {
	    binder.addValidators(ideaFileValidator);
	}
	
	@PostMapping("/registerIdea")
	public String checkPersonInfo(@Valid IdeaValidator ideaValidator, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		String videoFileName = "";
		String docFileName = "";
		String industry = "";
		String areaOfFunc = "";
		if (bindingResult.hasErrors()) {
			return "pricing";
		}
		
		System.out.println(ideaValidator);
		
		docFileName = new FileNameBuilder().generateFileName(ideaValidator.getDocFile().getOriginalFilename(), ideaValidator.getCapId(), "d");
		if(ideaValidator.getVideoFile() != null && ideaValidator.getVideoFile().isEmpty()){
			videoFileName = "NA";
		}else{
			videoFileName = new FileNameBuilder().generateFileName(ideaValidator.getVideoFile().getOriginalFilename(),ideaValidator.getCapId(),"v");

		}
		
		if(!ideaValidator.getIndustry().equals(null)){
			for(int i=0;i<ideaValidator.getIndustry().length;i++){
				industry = industry+";"+ideaValidator.getIndustry()[i];
			}
		}else{
			industry = "NA";
		}
		
		if(!ideaValidator.getFuncArea().equals(null)){
			for(int i=0;i<ideaValidator.getFuncArea().length;i++){
				areaOfFunc = areaOfFunc+";"+ideaValidator.getFuncArea()[i];
			}
		}else{
			areaOfFunc = "NA";
		}
		
		//Profile profileBean = new Profile(ideaValidator.getCapId(),ideaValidator.getIdeaThonName(), ideaValidator.getCapEmail());
		
		Profile profileBean = new Profile(ideaValidator.getName(),ideaValidator.getCapId(), ideaValidator.getCapEmail(),ideaValidator.getContactNum(),ideaValidator.getServicebu(),ideaValidator.getProjectName(),ideaValidator.getLocationName());
		//Stream<Profile> profile = Stream.of(new Profile(ideaValidator.getCapId(),ideaValidator.getIdeaThonName(), ideaValidator.getCapEmail()));
		//profile.forEach(profileRepository::save);
		
		Stream<Idea> ideas = Stream.of(new Idea(profileBean,ideaValidator.getProblemArea(), industry,areaOfFunc,ideaValidator.getTechnology(),ideaValidator.getSolnTitle(),ideaValidator.getSolnDesc(),ideaValidator.getBuBenift(), docFileName,videoFileName,"NA",0));
		ideas.forEach(ideaRepository::save);

		if(videoFileName != "NA"){
			storageService.storeIdea(ideaValidator.getDocFile(),docFileName,ideaValidator.getVideoFile(),videoFileName);
		}else{
			storageService.storeIdea(ideaValidator.getDocFile(),docFileName,null,"NA");
		}
		  redirectAttributes.addFlashAttribute("msgSubmit",
		  "You successfully uploaded your idea");
		  
		return "redirect:/submitIdea";
	}
	
	@PostMapping(value = "/rateIdea")
	public ResponseEntity<?> rateIdea(@RequestParam String capId,@RequestParam Float rating,@RequestParam String status){
		Profile profile = profileRepository.findOneByCapId(capId);
		System.out.println(profile);
		int val = ideaRepository.rateIdea(rating, status, profile.getId());
		System.out.println(val);
		if(val == 1){
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}else{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
	}
		
}
