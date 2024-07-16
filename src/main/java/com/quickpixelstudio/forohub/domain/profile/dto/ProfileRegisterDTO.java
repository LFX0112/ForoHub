package com.quickpixelstudio.forohub.domain.profile.dto;

import jakarta.validation.constraints.NotNull;

public record ProfileRegisterDTO(
        @NotNull
        String name,
        @NotNull
        String email
) {
}