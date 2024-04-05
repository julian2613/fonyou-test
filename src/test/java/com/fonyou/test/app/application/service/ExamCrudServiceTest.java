package com.fonyou.test.app.application.service;

import com.fonyou.test.app.application.mapper.ExamMapper;
import com.fonyou.test.app.application.model.request.exam.ExamRequest;
import com.fonyou.test.app.application.model.response.exam.ExamResponse;
import com.fonyou.test.app.domain.model.exam.Exam;
import com.fonyou.test.app.domain.model.student.Student;
import com.fonyou.test.app.domain.repository.ExamRepository;
import com.fonyou.test.shared.model.exception.OperationNotAllowed;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ExamCrudServiceTest {
    @Mock
    private ExamMapper mapper;

    @Mock
    private ExamRepository repository;

    @InjectMocks
    private ExamCrudService examCrudService;

    @Test
    public void create() throws OperationNotAllowed {
        Mockito.when(mapper.requestToEntity(any())).thenReturn(new Exam());
        Mockito.when(repository.save(any())).thenReturn(new Exam());
        Mockito.when(mapper.entityToResponse(any(Exam.class))).thenReturn(new ExamResponse());

        ExamRequest examRequest = new ExamRequest();
        examCrudService.create(examRequest);

        Mockito.verify(mapper).requestToEntity(any());
        Mockito.verify(repository).save(any());
        Mockito.verify(mapper).entityToResponse(any(Exam.class));
    }

    @Test
    public void findByStudent() {
        UUID studentId = UUID.randomUUID();

        Student student = new Student();
        student.setId(studentId);
        student.setTimezone("America/Boa_Vista");
        List<Student> students = new ArrayList<>();
        students.add(student);
        Exam exam = new Exam();
        exam.setPresentationDate(LocalDateTime.now());
        exam.setTimezone("America/Boa_Vista");
        exam.setStudents(students);
        List<Exam> exams = new ArrayList<>();
        exams.add(exam);
        Mockito.when(repository.findByStudentsId(any())).thenReturn(exams);

        Mockito.when(mapper.entityToExamFindByStudentResponse(any())).thenReturn(new ArrayList<>());

        examCrudService.findByStudent(studentId);

        Mockito.verify(repository).findByStudentsId(any());
        Mockito.verify(mapper).entityToExamFindByStudentResponse(any());
    }
}
