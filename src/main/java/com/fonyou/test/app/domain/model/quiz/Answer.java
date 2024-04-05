package com.fonyou.test.app.domain.model.quiz;

import java.io.Serializable;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Answer implements Serializable {
    private UUID id = UUID.randomUUID();

    private String description;

    private Boolean isCorrect;
}
