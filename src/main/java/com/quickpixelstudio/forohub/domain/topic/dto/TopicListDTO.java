package com.quickpixelstudio.forohub.domain.topic.dto;

import com.quickpixelstudio.forohub.domain.topic.Topic;

import java.time.LocalDateTime;

public record TopicListDTO(
        Long id,
        String title,
        String message,
        Boolean state,
        Long idAuthor,
        String author,
        Long idCourse,
        String course,
        LocalDateTime creationDate
) {
    public TopicListDTO(Topic topic){
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getStatus(),topic.getProfile().getId(),
                topic.getProfile().getName(), topic.getCourse().getId(), topic.getCourse().getName(),
                topic.getCreation_date());
    }
}