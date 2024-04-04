package com.fonyou.test.quiz.application.model.response;

import java.util.List;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class QuizResponse {
    private UUID id;

    private String name;

    private List<QuestionResponse> questions;
}
