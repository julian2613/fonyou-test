package com.fonyou.test.app.application.service;

import com.fonyou.test.shared.model.exception.OperationNotAllowed;
import com.fonyou.test.app.application.mapper.StudentMapper;
import com.fonyou.test.app.application.model.request.student.StudentRequest;
import com.fonyou.test.app.application.model.response.student.StudentResponse;
import com.fonyou.test.app.domain.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentCrudService {

    private final StudentMapper mapper;

    private final StudentRepository repository;

    public StudentCrudService(StudentMapper mapper, StudentRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public StudentResponse create(StudentRequest request) throws OperationNotAllowed {
        return this.mapper.entityToResponse(this.repository.save(this.mapper.requestToEntity(request)));
    }
}
