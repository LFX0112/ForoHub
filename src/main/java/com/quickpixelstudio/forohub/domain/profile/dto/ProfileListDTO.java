package com.quickpixelstudio.forohub.domain.profile.dto;

import java.util.List;

public record ProfileListDTO(
        Long id,
        String name,
        String email,
        List<String> topics
) {
}