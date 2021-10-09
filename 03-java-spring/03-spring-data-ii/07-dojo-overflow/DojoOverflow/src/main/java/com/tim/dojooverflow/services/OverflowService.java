package com.tim.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim.dojooverflow.models.Answer;
import com.tim.dojooverflow.models.Question;
import com.tim.dojooverflow.models.Tag;
import com.tim.dojooverflow.repositories.AnswerRepository;
import com.tim.dojooverflow.repositories.QuestionRepository;
import com.tim.dojooverflow.repositories.TagRepository;

@Service
public class OverflowService {
	@Autowired
	private QuestionRepository qRepo;
	@Autowired
	private AnswerRepository aRepo;
	@Autowired
	private TagRepository tRepo;
	
	public Tag getOneTag(String subject) {
		return this.tRepo.findBySubject(subject);
	}

	public ArrayList<Tag> splitTags(String tags) {
		ArrayList<Tag> tagsForQuestion = new ArrayList<Tag>();
		String[] tagsToProcess = tags.split(", ");
		for(String split : tagsToProcess) {
			if(this.tRepo.existsBySubject(split)) {
				Tag tagToAdd = this.getOneTag(split);
				tagsForQuestion.add(tagToAdd);
			}else {
				Tag newTag = new Tag();
				newTag.setSubject(split);
				this.tRepo.save(newTag);
				tagsForQuestion.add(this.getOneTag(split));
			}
		}
		
		return tagsForQuestion;
	}
	
	public Question createQuestion(Question question) {
		question.setQuestionstags(this.splitTags(question.getTagsFromFrontEnd()));
		return this.qRepo.save(question);
	}
	
	public Answer createAnswer(Answer answer) {
		return this.aRepo.save(answer);
	}
	
	public List<Question> getAllQuestion(){
		return this.qRepo.findAll();
	}
	
	public Question getOneQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
}
