package com.fonyou.test.app.application.model.response.student;

import java.time.LocalDate;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class StudentResponse {
    private UUID id;

    private String name;

    private LocalDate birthdate;

    private String city;

    private String timezone;
}
