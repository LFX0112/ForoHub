package com.quickpixelstudio.forohub.domain.answer.validations;

import com.quickpixelstudio.forohub.domain.answer.dto.AnswerCreateDTO;
import com.quickpixelstudio.forohub.domain.topic.TopicRepository;
import com.quickpixelstudio.forohub.infrastructure.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicValidation implements AnswerValidation{
    @Autowired
    private TopicRepository topicRepository;
    @Override
    public void validate(AnswerCreateDTO answerCreateDTO){
        if(topicRepository.findById(answerCreateDTO.idTopic()).isEmpty()){
            throw new IntegrityValidation("There is not found a topic with this ID");
        }
    }
}