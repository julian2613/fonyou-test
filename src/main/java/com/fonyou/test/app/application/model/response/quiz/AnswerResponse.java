package com.fonyou.test.app.application.model.response.quiz;

import java.util.UUID;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AnswerResponse {
    private UUID id;

    private String description;

    private Boolean isCorrect;
}
