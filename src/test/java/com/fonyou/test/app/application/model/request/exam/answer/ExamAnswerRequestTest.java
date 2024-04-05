package com.fonyou.test.app.application.model.request.exam.answer;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;

public class ExamAnswerRequestTest {
    @Test
    public void validateState() {
        ExamAnswerQuizRequest examAnswerQuizRequest = new ExamAnswerQuizRequest();
        ExamAnswerStudentRequest examAnswerStudentRequest = new ExamAnswerStudentRequest();
        List<StudentExamAnswerRequest> studentExamAnswerRequests = new ArrayList<>();
        ExamAnswerRequest request = new ExamAnswerRequest(examAnswerQuizRequest, examAnswerStudentRequest, studentExamAnswerRequests);
        assertThat(request.getQuiz(), equalTo(examAnswerQuizRequest));
        assertThat(request.getStudent(), equalTo(examAnswerStudentRequest));
        assertThat(request.getAnswers(), equalTo(studentExamAnswerRequests));
    }
}
