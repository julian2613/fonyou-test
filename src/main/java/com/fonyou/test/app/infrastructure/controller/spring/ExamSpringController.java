package com.fonyou.test.app.infrastructure.controller.spring;

import com.fonyou.test.app.application.model.request.exam.ExamRequest;
import com.fonyou.test.app.application.model.response.exam.ExamFindByStudentResponse;
import com.fonyou.test.app.application.model.response.exam.ExamResponse;
import com.fonyou.test.app.application.service.ExamCrudService;
import com.fonyou.test.shared.model.exception.OperationNotAllowed;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam")
public class ExamSpringController {
    private final ExamCrudService service;

    public ExamSpringController(ExamCrudService service) {
        this.service = service;
    }

    @PostMapping
    public ExamResponse create(@RequestBody @Valid ExamRequest request) throws OperationNotAllowed {
        return this.service.create(request);
    }

    @GetMapping("/findByStudent/{studentId}")
    public List<ExamFindByStudentResponse> findByStudentId(@PathVariable UUID studentId) {
        return this.service.findByStudent(studentId);
    }
}
