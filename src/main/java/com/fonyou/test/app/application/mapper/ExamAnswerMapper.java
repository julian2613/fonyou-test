package com.fonyou.test.app.application.mapper;

import com.fonyou.test.app.application.model.request.exam.answer.ExamAnswerRequest;
import com.fonyou.test.app.application.model.response.exam.answer.ExamAnswerResponse;
import com.fonyou.test.app.domain.model.exam.answer.ExamAnswer;
import com.fonyou.test.shared.application.mapper.CrudMapper;

public interface ExamAnswerMapper extends CrudMapper<ExamAnswerRequest, ExamAnswerResponse, ExamAnswer> {
}
