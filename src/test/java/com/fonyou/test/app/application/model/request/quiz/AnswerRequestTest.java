package com.fonyou.test.app.application.model.request.quiz;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;

public class AnswerRequestTest {
    @Test
    public void validateState() {
        AnswerRequest request = new AnswerRequest("description", Boolean.TRUE);
        assertThat(request.getDescription(), equalTo("description"));
        assertThat(request.getIsCorrect(), equalTo(Boolean.TRUE));
    }
}
