package com.fonyou.test.app.application.model.request.student;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class StudentRequest {
    @NotEmpty
    @Size(min = 1, max = 50)
    private String name;

    @NotNull
    private LocalDate birthdate;

    @NotEmpty
    @Size(min = 1, max = 50)
    private String city;

    @NotEmpty
    @Size(min = 1, max = 50)
    private String timezone;
}
