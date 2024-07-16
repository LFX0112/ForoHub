package com.quickpixelstudio.forohub.domain.answer.validations;

import com.quickpixelstudio.forohub.domain.answer.dto.AnswerCreateDTO;
import com.quickpixelstudio.forohub.domain.profile.ProfileRepository;
import com.quickpixelstudio.forohub.infrastructure.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnswerAuthorValidation implements AnswerValidation{
    @Autowired
    private ProfileRepository profileRepository;
    @Override
    public void validate(AnswerCreateDTO answerCreateDTO){
        if(profileRepository.findById(answerCreateDTO.idAuthor()).isEmpty()){
            throw new IntegrityValidation("There is not found a profile with this ID");
        }
    }
}