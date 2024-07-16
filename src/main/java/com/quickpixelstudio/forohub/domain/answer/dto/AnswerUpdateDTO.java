package com.quickpixelstudio.forohub.domain.answer.dto;

import jakarta.validation.constraints.NotNull;

public record AnswerUpdateDTO(
        @NotNull
        Long id,
        String message,
        Boolean solution
) {
}