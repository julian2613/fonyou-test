package com.fonyou.test.app.application.model.response.exam;

import java.util.UUID;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ExamQuizFindByStudentResponse {
    private UUID id;
    private String name;
}
