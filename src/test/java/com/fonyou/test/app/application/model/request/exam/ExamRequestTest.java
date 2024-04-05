package com.fonyou.test.app.application.model.request.exam;

import java.time.LocalDateTime;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;

public class ExamRequestTest {

    private final LocalDateTime PRESENTATION_DATE = LocalDateTime.now();

    @Test
    public void validateState() {
        String TIMEZONE = "America/Boa_Vista";
        ExamRequest request = new ExamRequest(PRESENTATION_DATE, TIMEZONE, null, null);
        assertThat(request.getPresentationDate(), equalTo(PRESENTATION_DATE));
        assertThat(request.getTimezone(), equalTo(TIMEZONE));
        assertThat(request.getQuiz(), equalTo(null));
        assertThat(request.getStudents(), equalTo(null));
    }
}
