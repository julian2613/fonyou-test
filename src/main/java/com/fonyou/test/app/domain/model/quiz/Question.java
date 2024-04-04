package com.fonyou.test.app.domain.model.quiz;

import java.io.Serializable;
import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Question implements Serializable {
    private String description;

    private Double value;

    private List<Answer> answers;
}
