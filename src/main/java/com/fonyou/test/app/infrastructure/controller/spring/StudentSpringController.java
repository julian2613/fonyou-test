package com.fonyou.test.app.infrastructure.controller.spring;

import com.fonyou.test.shared.model.exception.OperationNotAllowed;
import com.fonyou.test.app.application.model.request.student.StudentRequest;
import com.fonyou.test.app.application.model.response.student.StudentResponse;
import com.fonyou.test.app.application.service.StudentCrudService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentSpringController {
    private final StudentCrudService service;

    public StudentSpringController(StudentCrudService quizCrudService) {
        this.service = quizCrudService;
    }

    @PostMapping
    public StudentResponse create(@RequestBody @Valid StudentRequest request) throws OperationNotAllowed {
        return this.service.create(request);
    }
}
