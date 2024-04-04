package com.fonyou.test.app.application.service;

import com.fonyou.test.app.application.mapper.QuizMapper;
import com.fonyou.test.app.application.model.request.quiz.QuizRequest;
import com.fonyou.test.app.application.model.response.quiz.QuizResponse;
import com.fonyou.test.app.application.service.validator.QuizValidateOptions;
import com.fonyou.test.app.application.service.validator.QuizValidator;
import com.fonyou.test.app.domain.model.quiz.Quiz;
import com.fonyou.test.app.domain.repository.QuizRepository;
import com.fonyou.test.shared.model.exception.OperationNotAllowed;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class QuizCrudService {
    private final QuizMapper mapper;

    private final QuizRepository repository;

    private final QuizValidator quizValidator;

    public QuizCrudService(QuizMapper mapper, QuizRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
        this.quizValidator = QuizValidator.link(new QuizValidateOptions());
    }

    public QuizResponse create(QuizRequest request) throws OperationNotAllowed {
        Quiz entity = this.mapper.requestToEntity(request);
        this.quizValidator.validate(entity);

        try {
            return this.mapper.entityToResponse(this.repository.save(entity));
        } catch (DataIntegrityViolationException ex) {
            throw new OperationNotAllowed("The quiz already exists");
        }
    }
}
