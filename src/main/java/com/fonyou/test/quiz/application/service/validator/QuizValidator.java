package com.fonyou.test.quiz.application.service.validator;

import com.fonyou.test.quiz.domain.model.Quiz;
import com.fonyou.test.shared.model.exception.OperationNotAllowed;

public abstract class QuizValidator {
    private QuizValidator next;

    public static QuizValidator link(QuizValidator first, QuizValidator... chain) {
        QuizValidator head = first;
        for (QuizValidator nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract boolean validate(Quiz quiz) throws OperationNotAllowed;


    protected boolean validateNext(Quiz quiz) throws OperationNotAllowed {
        if (next == null) {
            return true;
        }
        return next.validate(quiz);
    }
}
