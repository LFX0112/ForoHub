package com.quickpixelstudio.forohub.domain.user.dto;

import jakarta.validation.constraints.NotNull;

public record AuthenticationDTO(
        @NotNull
        String username,
        @NotNull
        String password
) {
}