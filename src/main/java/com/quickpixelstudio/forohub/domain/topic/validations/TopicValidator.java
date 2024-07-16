package com.quickpixelstudio.forohub.domain.topic.validations;

import com.quickpixelstudio.forohub.domain.topic.dto.TopicRegisterDTO;

public interface TopicValidator {
    void validate(TopicRegisterDTO topicRegisterDTO);
}