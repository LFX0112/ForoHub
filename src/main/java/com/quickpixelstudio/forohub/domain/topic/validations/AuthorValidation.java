package com.quickpixelstudio.forohub.domain.topic.validations;

import com.quickpixelstudio.forohub.domain.profile.ProfileRepository;
import com.quickpixelstudio.forohub.domain.topic.dto.TopicRegisterDTO;
import com.quickpixelstudio.forohub.infrastructure.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorValidation implements TopicValidator{
    @Autowired
    private ProfileRepository profileRepository;
    @Override
    public void validate(TopicRegisterDTO topicRegisterDTO){
        if(profileRepository.findById(topicRegisterDTO.idAuthor()).isEmpty()){
            throw new IntegrityValidation("Profile not found with this ID");
        }
    }
}