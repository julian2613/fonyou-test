package com.fonyou.test.app.application.model.request.exam.answer;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ExamAnswerRequest {
    @NotNull
    @Valid
    private ExamAnswerQuizRequest quiz;

    @NotNull
    @Valid
    private ExamAnswerStudentRequest student;

    @NotEmpty
    @Valid
    private List<StudentExamAnswerRequest> answers;
}
