package com.fonyou.test.app.infrastructure.persistence.postgresql;

import com.fonyou.test.app.domain.model.student.Student;
import com.fonyou.test.app.domain.repository.StudentRepository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPostgresqlRepository extends JpaRepository<Student, UUID>, StudentRepository {
}
