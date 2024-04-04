package com.fonyou.test.quiz.application.service.validator;

import com.fonyou.test.quiz.domain.model.Answer;
import com.fonyou.test.quiz.domain.model.Question;
import com.fonyou.test.quiz.domain.model.Quiz;
import com.fonyou.test.shared.model.exception.OperationNotAllowed;

public class QuizValidateOptions extends QuizValidator {
    @Override
    public boolean validate(Quiz quiz) throws OperationNotAllowed {
        Double value = 0.0;
        for (Question question : quiz.getQuestions()) {
            if (question.getAnswers().size() != 4) {
                throw new OperationNotAllowed("Questions must have 4 options");
            } else {
                if (question.getAnswers().stream().filter(Answer::getIsCorrect).toList().size() > 1) {
                    throw new OperationNotAllowed("More than one option is correct");
                }
                value += question.getValue();
            }
        }

        if (value != 100.0) {
            throw new OperationNotAllowed("The sum of the value of the questions must be 100");
        }
        return validateNext(quiz);
    }
}
