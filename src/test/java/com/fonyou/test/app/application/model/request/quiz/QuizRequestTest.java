package com.fonyou.test.app.application.model.request.quiz;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;

public class QuizRequestTest {
    @Test
    public void validateState() {
        QuizRequest request = new QuizRequest("description", null);
        assertThat(request.getName(), equalTo("description"));
        assertThat(request.getQuestions(), equalTo(null));
    }
}
