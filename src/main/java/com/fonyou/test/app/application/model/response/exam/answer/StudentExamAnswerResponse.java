package com.fonyou.test.app.application.model.response.exam.answer;

import java.util.UUID;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class StudentExamAnswerResponse {
    private UUID questionId;
    private UUID answerId;
}
