package com.fonyou.test.app.infrastructure.mapper.mapstruct;

import com.fonyou.test.app.application.mapper.ExamMapper;
import com.fonyou.test.app.application.model.request.exam.ExamQuizRequest;
import com.fonyou.test.app.application.model.request.exam.ExamRequest;
import com.fonyou.test.app.application.model.request.exam.ExamStudentRequest;
import com.fonyou.test.app.application.model.response.exam.ExamFindByStudentResponse;
import com.fonyou.test.app.domain.model.exam.Exam;
import com.fonyou.test.app.domain.model.quiz.Quiz;
import com.fonyou.test.app.domain.model.student.Student;
import com.fonyou.test.shared.model.exception.OperationNotAllowed;
import java.time.ZoneId;
import java.time.zone.ZoneRulesException;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamMapstructMapper extends ExamMapper {

    Quiz examQuizRequestToQuiz(ExamQuizRequest request);

    List<Student> examStudentRequestToStudent(List<ExamStudentRequest> request);

    default Exam requestToEntity(ExamRequest request) throws OperationNotAllowed {
        Exam exam = new Exam();
        exam.setPresentationDate(request.getPresentationDate());
        exam.setQuiz(examQuizRequestToQuiz(request.getQuiz()));
        exam.setStudents(examStudentRequestToStudent(request.getStudents()));
        try {
            exam.setTimezone(ZoneId.of(request.getTimezone()).getId());
        } catch (ZoneRulesException ex) {
            throw new OperationNotAllowed("Invalid timezone");
        }
        return exam;
    }
}
