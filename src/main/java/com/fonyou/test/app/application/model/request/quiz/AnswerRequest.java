package com.fonyou.test.app.application.model.request.quiz;

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
