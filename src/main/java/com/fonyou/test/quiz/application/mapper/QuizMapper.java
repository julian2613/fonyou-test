package com.fonyou.test.quiz.application.mapper;

import com.fonyou.test.quiz.application.model.request.QuizRequest;
import com.fonyou.test.quiz.application.model.response.QuizResponse;
import com.fonyou.test.quiz.domain.model.Quiz;
import com.fonyou.test.shared.application.CrudMapper;

public interface QuizMapper extends CrudMapper<QuizRequest, QuizResponse, Quiz> {
}
