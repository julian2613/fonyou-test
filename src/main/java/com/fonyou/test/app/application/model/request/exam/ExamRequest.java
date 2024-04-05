package com.fonyou.test.app.application.model.request.exam;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ExamRequest {
    @NotNull
    private LocalDateTime presentationDate;

    @NotEmpty
    @Size(min = 1, max = 50)
    private String timezone;

    @NotNull
    @Valid
    private ExamQuizRequest quiz;

    @NotEmpty
    @Valid
    private List<ExamStudentRequest> students;
}