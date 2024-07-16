package com.quickpixelstudio.forohub.domain.profile.dto;

import jakarta.validation.constraints.NotNull;

public record ProfileUpdateDTO(
        @NotNull
        Long id,
        String name,
        String email
) {
}