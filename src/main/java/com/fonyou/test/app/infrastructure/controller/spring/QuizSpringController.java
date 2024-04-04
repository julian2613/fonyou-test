package com.fonyou.test.app.infrastructure.controller.spring;

import com.fonyou.test.app.application.model.request.quiz.QuizRequest;
import com.fonyou.test.app.application.model.response.quiz.QuizResponse;
import com.fonyou.test.app.application.service.QuizCrudService;
import com.fonyou.test.shared.model.exception.OperationNotAllowed;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class QuizSpringController {
    private final QuizCrudService service;

    public QuizSpringController(QuizCrudService quizCrudService) {
        this.service = quizCrudService;
    }

    @PostMapping
    public QuizResponse create(@RequestBody @Valid QuizRequest request) throws OperationNotAllowed {
        return this.service.create(request);
    }
}
