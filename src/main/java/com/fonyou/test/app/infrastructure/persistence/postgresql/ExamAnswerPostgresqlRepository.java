package com.fonyou.test.app.infrastructure.persistence.postgresql;

import com.fonyou.test.app.domain.model.exam.answer.ExamAnswer;
import com.fonyou.test.app.domain.repository.ExamAnswerRepository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamAnswerPostgresqlRepository extends JpaRepository<ExamAnswer, UUID>, ExamAnswerRepository {
}
