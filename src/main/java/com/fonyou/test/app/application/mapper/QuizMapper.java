package com.fonyou.test.app.application.mapper;

import com.fonyou.test.app.application.model.request.quiz.QuizRequest;
import com.fonyou.test.app.application.model.response.quiz.QuizResponse;
import com.fonyou.test.app.domain.model.quiz.Quiz;
import com.fonyou.test.shared.application.CrudMapper;

public interface QuizMapper extends CrudMapper<QuizRequest, QuizResponse, Quiz> {
}
