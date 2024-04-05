package com.fonyou.test.app.domain.repository;

import com.fonyou.test.app.domain.model.exam.Exam;
import com.fonyou.test.shared.model.repository.CrudRepository;
import java.util.List;
import java.util.UUID;

public interface ExamRepository extends CrudRepository<Exam> {
    List<Exam> findByStudentsId(UUID id);
}
