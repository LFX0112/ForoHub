package com.quickpixelstudio.forohub.domain.answer;

import com.quickpixelstudio.forohub.domain.answer.dto.AnswerCreateDTO;
import com.quickpixelstudio.forohub.domain.answer.dto.AnswerListDTO;
import com.quickpixelstudio.forohub.domain.answer.validations.AnswerValidation;
import com.quickpixelstudio.forohub.domain.profile.Profile;
import com.quickpixelstudio.forohub.domain.profile.ProfileRepository;
import com.quickpixelstudio.forohub.domain.topic.Topic;
import com.quickpixelstudio.forohub.domain.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CreateAnswerService {
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private List<AnswerValidation> answerValidationList;

    public AnswerListDTO create(AnswerCreateDTO answerCreateDTO){
        answerValidationList.forEach(v -> v.validate(answerCreateDTO));
        Profile profile = profileRepository.findById(answerCreateDTO.idAuthor()).get();
        Topic topic = topicRepository.findById(answerCreateDTO.idTopic()).get();
        LocalDateTime creationDate = LocalDateTime.now();
        Answer answer = new Answer(null, answerCreateDTO.message(), creationDate, false, true, profile, topic);
        answerRepository.save(answer);
        return new AnswerListDTO(answer);
    }
}