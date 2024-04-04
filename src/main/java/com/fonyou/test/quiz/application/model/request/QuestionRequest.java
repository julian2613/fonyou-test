package com.fonyou.test.quiz.application.model.request;

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
public class QuestionRequest {
    @NotEmpty
    private String description;

    @NotNull
    private Double value;

    @NotEmpty
    @Valid
    private List<AnswerRequest> answers;
}
