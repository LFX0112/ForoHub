package com.quickpixelstudio.forohub.domain.answer.dto;

import com.quickpixelstudio.forohub.domain.answer.Answer;

import java.time.LocalDateTime;

public record AnswerListDTO(
        Long id,
        String message,
        LocalDateTime creationDate,
        Boolean isSolution,
        Long idAuthor,
        String author,
        Long idTopic,
        String topic
) {
    public AnswerListDTO(Answer answer){
        this(answer.getId(), answer.getMessage(), answer.getCreation_date(), answer.getSolution(), answer.getProfile().getId(), answer.getProfile().getName(), answer.getTopic().getId(), answer.getTopic().getTitle());
    }
}