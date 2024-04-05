package com.fonyou.test.app.application.model.request.exam.answer;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ExamAnswerStudentRequest {
    @NotNull
    private UUID id;
}
