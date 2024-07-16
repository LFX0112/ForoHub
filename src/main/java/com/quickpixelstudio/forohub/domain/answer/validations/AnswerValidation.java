package com.quickpixelstudio.forohub.domain.answer.validations;

import com.quickpixelstudio.forohub.domain.answer.dto.AnswerCreateDTO;

public interface AnswerValidation {
    void validate(AnswerCreateDTO answerCreateDTO);
}
