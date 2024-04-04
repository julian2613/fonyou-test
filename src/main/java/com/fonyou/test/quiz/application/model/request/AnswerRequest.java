package com.fonyou.test.quiz.application.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AnswerRequest {
    @NotEmpty
    private String description;

    @NotNull
    private Boolean isCorrect;
}
