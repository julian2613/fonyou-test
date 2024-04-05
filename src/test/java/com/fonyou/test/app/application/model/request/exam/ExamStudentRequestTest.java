package com.fonyou.test.app.application.model.request.exam;

import java.util.UUID;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;

public class ExamStudentRequestTest {
    private final UUID RANDOM_UUID = UUID.randomUUID();

    @Test
    public void validateState() {
        ExamStudentRequest request = new ExamStudentRequest(RANDOM_UUID);
        assertThat(request.getId(), equalTo(RANDOM_UUID));
    }
}
