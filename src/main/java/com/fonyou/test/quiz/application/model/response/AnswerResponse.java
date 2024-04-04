package com.fonyou.test.quiz.application.model.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AnswerResponse {
    private String description;

    private Boolean isCorrect;
}
