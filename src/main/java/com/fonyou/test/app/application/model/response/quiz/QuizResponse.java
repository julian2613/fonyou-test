package com.fonyou.test.app.application.model.response.quiz;

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
