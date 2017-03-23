package com.vv.main;

import java.io.IOException;
import java.util.Locale;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vv.model.IdeaValidator;
import com.vv.service.EmailService;

@Controller
public class AppRouter {
	@Autowired
	private EmailService emailService;

	@GetMapping("/")
    public String Main() throws MessagingException {
		String baseTemplateName = "index";
        return baseTemplateName;
    }
	
	@GetMapping("/index")
    public String indexPage() {
		String baseTemplateName = "index";
        return baseTemplateName;
    }
	
	@GetMapping("/email")
    public String emailPage() throws MessagingException {
		//emailService.sendTextMail("venkatesh", "venkat.kristipati@gmail.com", new Locale("en_US"));
		emailService.sendTextMail("venkatesh", "venkat.kristipati@gmail.com", new Locale("fr"));
        return "index";
    }
	
	@GetMapping("/contact")
    public String contactPage() {
		String contactTemplateName = "contact";
        return contactTemplateName;
    }
	
	@GetMapping("/blog")
    public String blogPage() {
		String blogTemplateName = "blog";
        return blogTemplateName;
    }
	
	@GetMapping("/about")
    public String aboutPage() {
		String aboutTemplateName = "about";
        return aboutTemplateName;
    }
	
	@GetMapping("/gallery")
    public String galleryPage() {
		//String baseTemplateName = "EnterExpenses";
		String galleryTemplateName = "gallery";
        return galleryTemplateName;
    }
	
	@GetMapping("/submitIdea")
    public String pricingPage(IdeaValidator ideaValidator) {
		String pricingTemplateName = "ideaForm";
        return pricingTemplateName;
    }
	
	@GetMapping("/results")
    public String resultsPage() {
		String resultsTemplateName = "results";
        return resultsTemplateName;
    }
	
	@GetMapping("/schedule")
    public String schedulePage() {
		String scheduleTemplateName = "schedule";
        return scheduleTemplateName;
    }
	
	@GetMapping("/singleView")
    public String singlePostPage() {
		String singlePostTemplateName = "singleView";
        return singlePostTemplateName;
    }
	
	@GetMapping("/speakers")
    public String speakersPage() {
		String speakersTemplateName = "speakers";
        return speakersTemplateName;
    }
	
	@GetMapping("/sponsors")
    public String sponsorsPage() {
		String sponsorsTemplateName = "sponsors";
        return sponsorsTemplateName;
    }
	
	@GetMapping("/ideaList")
    public String ideasPage() {
		String ideasTemplateName = "ideas";
        return ideasTemplateName;
    }
	
	@GetMapping("/login")
    public String loginPage() {
		String ideasTemplateName = "login";
        return ideasTemplateName;
    }
	
	@GetMapping(value = "/editable")
    public String editable(final Model model) throws IOException {
        model.addAttribute("baseTemplate", this.emailService.getEditableMailTemplate());
        return "editable";
    }
	
	/*@GetMapping("/hello")
    public String E404Page() {
		String error404Page = "404";
        return error404Page;
    }*/
	
	/*@GetMapping("/old")
    public String viewHomePage(Model model) throws IOException {
		String baseTemplateName = "EnterExpenses";
        return baseTemplateName;
    }*/
	
}
