package com.quickpixelstudio.forohub.domain.topic;

import com.quickpixelstudio.forohub.domain.course.Course;
import com.quickpixelstudio.forohub.domain.course.CourseRepository;
import com.quickpixelstudio.forohub.domain.profile.Profile;
import com.quickpixelstudio.forohub.domain.profile.ProfileRepository;
import com.quickpixelstudio.forohub.domain.topic.dto.TopicListDTO;
import com.quickpixelstudio.forohub.domain.topic.dto.TopicRegisterDTO;
import com.quickpixelstudio.forohub.domain.topic.validations.TopicValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicServiceCreate {
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    List<TopicValidator> validatorList;

    public TopicListDTO create(TopicRegisterDTO topicRegisterDTO){
        validatorList.forEach(v -> v.validate(topicRegisterDTO));

        Profile profile = profileRepository.findById(topicRegisterDTO.idAuthor()).get();
        Course course = courseRepository.findById(topicRegisterDTO.idCourse()).get();

        LocalDateTime creationDate = LocalDateTime.now();
        Topic topic = new Topic(null, topicRegisterDTO.title(), topicRegisterDTO.message(), creationDate, false, true, null, profile, course);
        topicRepository.save(topic);
        return new TopicListDTO(topic);
    }
}