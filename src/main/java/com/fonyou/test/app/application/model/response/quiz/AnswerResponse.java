package com.fonyou.test.app.application.model.response.quiz;

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
