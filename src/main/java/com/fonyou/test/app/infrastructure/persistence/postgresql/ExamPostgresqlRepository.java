package com.fonyou.test.app.infrastructure.persistence.postgresql;

import com.fonyou.test.app.domain.model.exam.Exam;
import com.fonyou.test.app.domain.repository.ExamRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamPostgresqlRepository extends JpaRepository<Exam, UUID>, ExamRepository {
    List<Exam> findByStudentsId(UUID id);
}
