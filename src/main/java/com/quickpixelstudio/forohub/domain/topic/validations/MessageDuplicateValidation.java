package com.quickpixelstudio.forohub.domain.topic.validations;

import com.quickpixelstudio.forohub.domain.topic.Topic;
import com.quickpixelstudio.forohub.domain.topic.TopicRepository;
import com.quickpixelstudio.forohub.domain.topic.dto.TopicRegisterDTO;
import com.quickpixelstudio.forohub.infrastructure.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MessageDuplicateValidation implements TopicValidator{
    @Autowired
    private TopicRepository topicRepository;
    @Override
    public void validate(TopicRegisterDTO topicRegisterDTO){
        Optional<Topic> topic = topicRepository.findByMessage(topicRegisterDTO.message());
        if(topic.isPresent()){
            throw new IntegrityValidation("There is already a topic with this same message");
        }
    }
}