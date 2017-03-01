package com.vv.main;

import java.io.IOException;
import java.util.Locale;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vv.model.ExpenseFeedForm;
import com.vv.model.IdeaValidator;
import com.vv.service.EmailService;

@Controller
public class AppController {
	@Autowired
	private EmailService emailService;
	@GetMapping("/register")
    public String showExpenseEntryForm(ExpenseFeedForm expenseFeedForm) {
		String baseTemplateName = "EnterExpenses";
		//String baseTemplateName = "index";
        return baseTemplateName;
    }
	
	@GetMapping("/")
    public String Main() throws MessagingException {
		//String baseTemplateName = "EnterExpenses";
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
		//String baseTemplateName = "EnterExpenses";
		String blogTemplateName = "blog";
        return blogTemplateName;
    }
	
	@GetMapping("/about")
    public String aboutPage() {
		//String baseTemplateName = "EnterExpenses";
		String aboutTemplateName = "about";
        return aboutTemplateName;
    }
	
	@GetMapping("/gallery")
    public String galleryPage() {
		//String baseTemplateName = "EnterExpenses";
		String galleryTemplateName = "gallery";
        return galleryTemplateName;
    }
	
	@GetMapping("/pricing")
    public String pricingPage(IdeaValidator ideaValidator) {
		//String baseTemplateName = "EnterExpenses";
		String pricingTemplateName = "pricing";
        return pricingTemplateName;
    }
	
	@GetMapping("/results")
    public String resultsPage() {
		//String baseTemplateName = "EnterExpenses";
		String resultsTemplateName = "results";
        return resultsTemplateName;
    }
	
	@GetMapping("/schedule")
    public String schedulePage() {
		//String baseTemplateName = "EnterExpenses";
		String scheduleTemplateName = "schedule";
        return scheduleTemplateName;
    }
	
	@GetMapping("/single-post")
    public String singlePostPage() {
		//String baseTemplateName = "EnterExpenses";
		String singlePostTemplateName = "single-post";
        return singlePostTemplateName;
    }
	
	@GetMapping("/speakers")
    public String speakersPage() {
		//String baseTemplateName = "EnterExpenses";
		String speakersTemplateName = "speakers";
        return speakersTemplateName;
    }
	
	@GetMapping("/sponsors")
    public String sponsorsPage() {
		//String baseTemplateName = "EnterExpenses";
		String sponsorsTemplateName = "sponsors";
        return sponsorsTemplateName;
    }
	
	@GetMapping("/ideaList")
    public String ideasPage() {
		//String baseTemplateName = "EnterExpenses";
		String ideasTemplateName = "ideas";
        return ideasTemplateName;
    }
	
	@GetMapping(value = "/editable")
    public String editable(final Model model) throws IOException {
        model.addAttribute("baseTemplate", this.emailService.getEditableMailTemplate());
        return "editable";
    }
	
	/*@GetMapping("/old")
    public String viewHomePage(Model model) throws IOException {
		String baseTemplateName = "EnterExpenses";
        return baseTemplateName;
    }*/
	
}
