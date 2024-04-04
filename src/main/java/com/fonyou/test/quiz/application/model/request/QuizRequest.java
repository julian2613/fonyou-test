package com.fonyou.test.quiz.application.model.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class QuizRequest {
    @NotEmpty
    private String name;

    @NotEmpty
    @Valid
    private List<QuestionRequest> questions;
}
