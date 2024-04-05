package com.fonyou.test.app.application.model.request.exam.answer;

import java.util.UUID;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;

public class ExamAnswerStudentRequestTest {
    private final UUID RANDOM_UUID = UUID.randomUUID();

    @Test
    public void validateState() {
        ExamAnswerStudentRequest request = new ExamAnswerStudentRequest(RANDOM_UUID);
        assertThat(request.getId(), equalTo(RANDOM_UUID));
    }
}
