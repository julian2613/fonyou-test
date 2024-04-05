package com.fonyou.test.app.application.model.response.exam;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ExamFindByStudentResponse {
    private UUID id;
    private LocalDateTime presentationDate;
    private String timezone;
    private ExamQuizFindByStudentResponse quiz;
}
