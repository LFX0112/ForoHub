package com.quickpixelstudio.forohub.domain.topic.dto;

import jakarta.validation.constraints.NotNull;

public record TopicRegisterDTO(
        @NotNull
        String title,
        @NotNull
        String message,
        @NotNull
        Long idAuthor,
        @NotNull
        Long idCourse
) {
}