package com.fonyou.test.app.application.model.request.exam.answer;

import java.util.UUID;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;

public class StudentExamAnswerRequestTest {
    private final UUID RANDOM_UUID = UUID.randomUUID();

    @Test
    public void validateState() {
        StudentExamAnswerRequest request = new StudentExamAnswerRequest(RANDOM_UUID, RANDOM_UUID);
        assertThat(request.getQuestionId(), equalTo(RANDOM_UUID));
        assertThat(request.getAnswerId(), equalTo(RANDOM_UUID));
    }
}
