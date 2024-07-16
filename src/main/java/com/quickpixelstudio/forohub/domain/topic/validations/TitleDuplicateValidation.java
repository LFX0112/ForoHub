package com.quickpixelstudio.forohub.domain.topic.validations;

import com.quickpixelstudio.forohub.domain.topic.Topic;
import com.quickpixelstudio.forohub.domain.topic.TopicRepository;
import com.quickpixelstudio.forohub.domain.topic.dto.TopicRegisterDTO;
import com.quickpixelstudio.forohub.infrastructure.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TitleDuplicateValidation implements TopicValidator{
    @Autowired
    private TopicRepository topicRepository;
    @Override
    public void validate(TopicRegisterDTO topicRegisterDTO){
        Optional<Topic> topic = topicRepository.findByTitle(topicRegisterDTO.title());
        if(topic.isPresent()){
            throw new IntegrityValidation("There is alredy exists a topic with same Title");
        }
    }
}