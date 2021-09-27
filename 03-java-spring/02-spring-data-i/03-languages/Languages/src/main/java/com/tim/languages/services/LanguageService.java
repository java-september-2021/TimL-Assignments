package com.tim.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tim.languages.models.Language;
import com.tim.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository lRepo;
	
	public LanguageService(LanguageRepository repo) {
		this.lRepo = repo;
	}
	
	public List<Language> allLanguages(){
		return this.lRepo.findAll();
	}
	
	public Language findLanguage(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	
	public Language createLanguage(Language newLanguage) {
		return this.lRepo.save(newLanguage);
	}
	
	public Language updateLanguage(Language updateLanguage) {
		return this.lRepo.save(updateLanguage);
	}
	
	public void deleteLanguage(Long id) {
		this.lRepo.deleteById(id);
	}
	
}
