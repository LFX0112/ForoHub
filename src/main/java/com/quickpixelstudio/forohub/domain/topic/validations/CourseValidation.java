package com.quickpixelstudio.forohub.domain.topic.validations;

import com.quickpixelstudio.forohub.domain.course.CourseRepository;
import com.quickpixelstudio.forohub.domain.topic.dto.TopicRegisterDTO;
import com.quickpixelstudio.forohub.infrastructure.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseValidation implements TopicValidator {
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public void validate(TopicRegisterDTO topicRegisterDTO){
        if(courseRepository.findById(topicRegisterDTO.idCourse()).isEmpty()){
            throw new IntegrityValidation("Course not found with this ID");
        }
    }
}