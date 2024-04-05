package com.fonyou.test.app.infrastructure.controller.spring;

import com.fonyou.test.app.application.model.request.exam.answer.ExamAnswerRequest;
import com.fonyou.test.app.application.model.response.exam.answer.ExamAnswerResponse;
import com.fonyou.test.app.application.service.ExamAnswerCrudService;
import com.fonyou.test.shared.model.exception.OperationNotAllowed;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam-answer")
public class ExamAnswerSpringController {
    private final ExamAnswerCrudService service;

    public ExamAnswerSpringController(ExamAnswerCrudService service) {
        this.service = service;
    }

    @PostMapping
    public ExamAnswerResponse create(@RequestBody @Valid ExamAnswerRequest request) throws OperationNotAllowed {
        return this.service.create(request);
    }
}
