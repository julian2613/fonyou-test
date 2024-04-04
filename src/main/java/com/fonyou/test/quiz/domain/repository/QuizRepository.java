package com.fonyou.test.quiz.domain.repository;

import com.fonyou.test.quiz.domain.model.Quiz;

public interface QuizRepository {
    Quiz save(Quiz quiz);
}
