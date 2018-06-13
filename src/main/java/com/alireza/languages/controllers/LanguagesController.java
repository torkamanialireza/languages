package com.alireza.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alireza.languages.models.Language;
import com.alireza.languages.services.LanguageService;
import com.alireza.mvc.models.Book;

@Controller
public class LanguagesController {
	private final LanguageService languageService;
	
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	//for index
	@RequestMapping("/")
	public String newLanguage(@ModelAttribute("language") Language language) {
	       return "/languages/index.jsp";
	}
	//for show all languages in index
	@RequestMapping("/languages")
	public String index(Model model) {
		List <Language> languages = languageService.allLanguages(); 
		model.addAttribute("languages", languages);
		return ("languages/index.jsp");	
	}
	
	 @PostMapping(value="/new")
	 public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		 
	     if (result.hasErrors()) {	   
	    	 return "redirect:/languages";
	     } else {
	        	
	            languageService.createLanguage(language);
	            return "redirect:/languages";
	     }
	 }
	 //for show language
	 @RequestMapping("/languages/{id}")
	 public String showLaguage(Model model,@PathVariable("id") Long id) {
		 Language language = languageService.findLanguage(id);
		 model.addAttribute("language", language);
		 
	     return "/languages/show.jsp";
	 }
	 //show edit page before updating
	 @RequestMapping("/languages/edit/{id}")
	 public String editLaguage(Model model,@PathVariable("id") Long id) {
		 Language language = languageService.findLanguage(id);
		 model.addAttribute("language", language); 
	     return "/languages/edit.jsp";
	 }
	// edit form for updating
	 @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
	 public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		 
	     if (result.hasErrors()) {
	    	 
	         return "/languages/edit.jsp";
	     } else {

	    	 languageService.updateLanguage(language);  
	         return "redirect:/languages";
	     }
	 }
	// Delete From database
	 @RequestMapping(value="/languages/delete/{id}")
	 public String deleteLanguage(@PathVariable("id") Long id) {
		  languageService.deleteLanguage(id);
		  return "redirect:/languages";
	 }
		    
	 
	 
	 
	

}
