package com.fonyou.test.app.domain.model.quiz;

import java.io.Serializable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Answer implements Serializable {
    private String description;

    private Boolean isCorrect;
}
