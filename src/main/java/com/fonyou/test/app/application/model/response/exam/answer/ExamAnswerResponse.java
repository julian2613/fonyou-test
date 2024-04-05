package com.fonyou.test.app.application.model.response.exam.answer;

import java.util.List;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ExamAnswerResponse {
    private UUID id;

    private Double score;

    private ExamAnswerQuizResponse quiz;

    private ExamAnswerStudentResponse student;

    private List<StudentExamAnswerResponse> answers;
}
