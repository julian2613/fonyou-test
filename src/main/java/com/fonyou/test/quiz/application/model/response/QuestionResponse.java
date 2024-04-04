package com.fonyou.test.quiz.application.model.response;

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
