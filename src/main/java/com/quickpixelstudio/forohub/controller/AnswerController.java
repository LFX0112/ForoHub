package com.quickpixelstudio.forohub.controller;

import com.quickpixelstudio.forohub.domain.answer.CreateAnswerService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/responses")
@SecurityRequirement(name = "bearer-key")
public class AnswerController {
    @Autowired
    private CreateAnswerService answerService;
}