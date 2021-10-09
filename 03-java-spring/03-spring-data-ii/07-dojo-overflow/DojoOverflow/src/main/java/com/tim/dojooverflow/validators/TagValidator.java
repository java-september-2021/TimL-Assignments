package com.tim.dojooverflow.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.tim.dojooverflow.models.Question;


@Component
public class TagValidator {
    public boolean supports(Class<?> clazz) {
    return Question.class.equals(clazz);
    }
    
    public void validate(Object target, Errors errors) {
        Question question = (Question) target;
        
        String[] tags = question.getTagsFromFrontEnd().split(", ");
        if(tags.length > 3) {
        	errors.rejectValue("tagsFromFrontEnd", "too Many", "Maximum of 3 tags per question.");
        }
    }

}
