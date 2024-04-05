package com.fonyou.test.app.domain.model.quiz;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Question implements Serializable {
    private UUID id = UUID.randomUUID();

    private String description;

    private Double value;

    private List<Answer> answers;
}
