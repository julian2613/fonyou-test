package com.fonyou.test.app.application.model.request.student;

import java.time.LocalDate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;

public class StudentRequestTest {
    @Test
    public void validateState() {
        LocalDate date = LocalDate.now();
        StudentRequest request = new StudentRequest("name", date, "city", "America/Boa_Vista");
        assertThat(request.getName(), equalTo("name"));
        assertThat(request.getBirthdate(), equalTo(date));
        assertThat(request.getCity(), equalTo("city"));
        assertThat(request.getTimezone(), equalTo("America/Boa_Vista"));
    }
}
