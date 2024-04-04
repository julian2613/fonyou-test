package com.fonyou.test.app.application.model.response.quiz;

import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class QuestionResponse {
    private String description;

    private List<AnswerResponse> answers;
}
