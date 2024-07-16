package com.quickpixelstudio.forohub.domain.answer.dto;

import jakarta.validation.constraints.NotNull;

public record AnswerCreateDTO(
        @NotNull
        String message,
        @NotNull
        Long idAuthor,
        @NotNull
        Long idTopic
) {
}