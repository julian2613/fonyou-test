package com.fonyou.test.quiz.infrastructure.persistence.postgresql;

import com.fonyou.test.quiz.domain.model.Quiz;
import com.fonyou.test.quiz.domain.repository.QuizRepository;
import java.util.UUID;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface QuizPostgresqlRepository extends JpaRepository<Quiz, UUID>, QuizRepository {
}
