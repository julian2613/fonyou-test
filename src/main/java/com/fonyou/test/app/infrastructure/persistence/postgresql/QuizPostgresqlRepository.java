package com.fonyou.test.app.infrastructure.persistence.postgresql;

import com.fonyou.test.app.domain.model.quiz.Quiz;
import com.fonyou.test.app.domain.repository.QuizRepository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizPostgresqlRepository extends JpaRepository<Quiz, UUID>, QuizRepository {
}
