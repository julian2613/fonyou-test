package com.fonyou.test.app.application.mapper;

import com.fonyou.test.app.application.model.request.exam.ExamRequest;
import com.fonyou.test.app.application.model.response.exam.ExamFindByStudentResponse;
import com.fonyou.test.app.application.model.response.exam.ExamResponse;
import com.fonyou.test.app.domain.model.exam.Exam;
import com.fonyou.test.shared.application.mapper.CrudMapper;
import java.util.List;

public interface ExamMapper extends CrudMapper<ExamRequest, ExamResponse, Exam> {
    List<ExamFindByStudentResponse> entityToExamFindByStudentResponse(List<Exam> entity);
}
