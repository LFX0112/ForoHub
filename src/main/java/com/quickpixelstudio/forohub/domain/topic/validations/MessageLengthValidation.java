package com.quickpixelstudio.forohub.domain.topic.validations;

import com.quickpixelstudio.forohub.domain.topic.dto.TopicRegisterDTO;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class MessageLengthValidation implements TopicValidator{
    public void validate(TopicRegisterDTO topicRegisterDTO){
        if(topicRegisterDTO.message().length() < 10) {
            throw new ValidationException("This message is too short, remember it has descriptive");
        }
        if(topicRegisterDTO.message().length() > 99) {
            throw new ValidationException("This message is too long");
        }
    }
}