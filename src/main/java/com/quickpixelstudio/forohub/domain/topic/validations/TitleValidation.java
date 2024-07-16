package com.quickpixelstudio.forohub.domain.topic.validations;

import com.quickpixelstudio.forohub.domain.topic.dto.TopicRegisterDTO;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class TitleValidation implements TopicValidator{
    public void validate(TopicRegisterDTO topicRegisterDTO){
        if(topicRegisterDTO.title().length() < 4){
            throw new ValidationException("This title is too short, remember it has descriptive");
        }
    }
}