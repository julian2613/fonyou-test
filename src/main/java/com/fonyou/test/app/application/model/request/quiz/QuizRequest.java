package com.fonyou.test.app.application.model.request.quiz;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
    @Size(min = 1, max = 50)
    private String name;

    @NotEmpty
    @Valid
    private List<QuestionRequest> questions;
}
