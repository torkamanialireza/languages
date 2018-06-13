package com.alireza.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alireza.languages.models.Language;
import com.alireza.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	// returns all the languages
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    // create language
    public Language createLanguage(Language b) {
    	return languageRepository.save(b);
    }
    //find Language
    public Language findLanguage(Long id) {
    	Optional<Language> optionalLanguage = languageRepository.findById(id);
    	if (optionalLanguage.isPresent()) {
    		return optionalLanguage.get();
    	}else {
    		return null;
    	}
    }
    //update language in post
    public Language updateLanguage(Long id, String name, String creator, Integer currentVersion) {
    	Optional<Language> temp = languageRepository.findById(id);
    	Language language = temp.get();
    	language.setName(name);
    	language.setCreator(creator);
    	language.setCurrentVersion(currentVersion);
    	return languageRepository.save(language);
    	
    }
    public Language updateLanguage(Language language) {
    	return languageRepository.save(language);
    }
    
    //delete language
    public void deleteLanguage(Long id) {
    	languageRepository.deleteById(id);
    }
    

}
