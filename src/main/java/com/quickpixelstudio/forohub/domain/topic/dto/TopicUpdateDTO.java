package com.quickpixelstudio.forohub.domain.topic.dto;

import jakarta.validation.constraints.NotNull;

public record TopicUpdateDTO(
        @NotNull
        Long id,
        String title,
        String message,
        Boolean status
) {
}