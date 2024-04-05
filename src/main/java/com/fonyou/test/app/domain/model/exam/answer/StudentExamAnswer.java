package com.fonyou.test.app.domain.model.exam.answer;

import java.io.Serializable;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class StudentExamAnswer implements Serializable {
    private UUID questionId;
    private UUID answerId;
}
