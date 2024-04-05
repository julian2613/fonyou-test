package com.fonyou.test.app.application.model.response.exam;

import com.fonyou.test.app.application.model.request.exam.ExamRequest;
import com.fonyou.test.app.application.model.request.exam.ExamStudentRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ExamResponse {
    private UUID id;

    private LocalDateTime presentationDate;

    private String timezone;

    private ExamQuizResponse quiz;

    private List<ExamStudentRequest> students;
}
