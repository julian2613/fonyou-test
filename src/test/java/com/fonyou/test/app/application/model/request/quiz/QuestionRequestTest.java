package com.fonyou.test.app.application.model.request.quiz;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;

public class QuestionRequestTest {
    @Test
    public void validateState() {
        QuestionRequest request = new QuestionRequest("description", 0.0, null);
        assertThat(request.getDescription(), equalTo("description"));
        assertThat(request.getValue(), equalTo(0.0));
        assertThat(request.getAnswers(), equalTo(null));
    }
}
