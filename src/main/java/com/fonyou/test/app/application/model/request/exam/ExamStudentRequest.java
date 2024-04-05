package com.fonyou.test.app.application.model.request.exam;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ExamStudentRequest {
    @NotNull
    private UUID id;
}
