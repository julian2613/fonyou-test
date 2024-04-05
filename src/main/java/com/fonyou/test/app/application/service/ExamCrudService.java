package com.fonyou.test.app.application.service;

import com.fonyou.test.app.application.mapper.ExamMapper;
import com.fonyou.test.app.application.model.request.exam.ExamRequest;
import com.fonyou.test.app.application.model.response.exam.ExamFindByStudentResponse;
import com.fonyou.test.app.application.model.response.exam.ExamResponse;
import com.fonyou.test.app.domain.model.exam.Exam;
import com.fonyou.test.app.domain.model.student.Student;
import com.fonyou.test.app.domain.repository.ExamRepository;
import com.fonyou.test.shared.model.exception.OperationNotAllowed;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class ExamCrudService {
    private final ExamMapper mapper;

    private final ExamRepository repository;

    public ExamCrudService(ExamMapper mapper, ExamRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public ExamResponse create(ExamRequest request) throws OperationNotAllowed {
        return this.mapper.entityToResponse(this.repository.save(this.mapper.requestToEntity(request)));
    }

    public List<ExamFindByStudentResponse> findByStudent(UUID studentId) {
        List<Exam> entities = this.repository.findByStudentsId(studentId);
        entities.forEach((Exam entity) -> {
            ZoneId oldZone = ZoneId.of(entity.getTimezone());

            Student student = entity.getStudents().stream().filter((Student filter) -> filter.getId().equals(studentId)).toList().getFirst();
            ZoneId newZone = ZoneId.of(student.getTimezone());
            entity.setPresentationDate(entity.getPresentationDate().atZone(oldZone).withZoneSameInstant(newZone).toLocalDateTime());
            entity.setTimezone(student.getTimezone());
        });

        return this.mapper.entityToExamFindByStudentResponse(entities);
    }
}
