package com.fonyou.test.app.application.service;

import com.fonyou.test.app.application.mapper.ExamAnswerMapper;
import com.fonyou.test.app.application.model.request.exam.answer.ExamAnswerQuizRequest;
import com.fonyou.test.app.application.model.request.exam.answer.ExamAnswerRequest;
import com.fonyou.test.app.application.model.request.exam.answer.ExamAnswerStudentRequest;
import com.fonyou.test.app.application.model.response.exam.answer.ExamAnswerResponse;
import com.fonyou.test.app.domain.model.exam.answer.ExamAnswer;
import com.fonyou.test.app.domain.model.exam.answer.StudentExamAnswer;
import com.fonyou.test.app.domain.model.quiz.Answer;
import com.fonyou.test.app.domain.model.quiz.Question;
import com.fonyou.test.app.domain.model.quiz.Quiz;
import com.fonyou.test.app.domain.model.student.Student;
import com.fonyou.test.app.domain.repository.ExamAnswerRepository;
import com.fonyou.test.app.domain.repository.QuizRepository;
import com.fonyou.test.shared.model.exception.OperationNotAllowed;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ExamAnswerCrudServiceTest {
    @Mock
    private ExamAnswerMapper mapper;

    @Mock
    private ExamAnswerRepository repository;

    @Mock
    private QuizRepository quizRepository;

    @InjectMocks
    private ExamAnswerCrudService examAnswerCrudService;

    @Test
    public void create() throws OperationNotAllowed {
        UUID questionId = UUID.randomUUID();
        UUID answerId = UUID.randomUUID();

        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer(answerId, "description", true));
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(questionId, "description", 100.0, answers));
        Quiz quiz = new Quiz(UUID.randomUUID(), "name", questions);
        Mockito.when(quizRepository.findById(any())).thenReturn(Optional.of(quiz));

        List<StudentExamAnswer> studentExamAnswer = new ArrayList<>();
        studentExamAnswer.add(new StudentExamAnswer(questionId, answerId));
        ExamAnswer examAnswer = new ExamAnswer(UUID.randomUUID(), 0.0, quiz, new Student(), studentExamAnswer);
        Mockito.when(mapper.requestToEntity(any())).thenReturn(examAnswer);
        Mockito.when(repository.save(any())).thenReturn(examAnswer);

        ExamAnswerResponse examAnswerResponse = new ExamAnswerResponse();
        Mockito.when(mapper.entityToResponse(any(ExamAnswer.class))).thenReturn(examAnswerResponse);

        ExamAnswerRequest examAnswerRequest = new ExamAnswerRequest(new ExamAnswerQuizRequest(UUID.randomUUID()), new ExamAnswerStudentRequest(), new ArrayList<>());
        examAnswerCrudService.create(examAnswerRequest);

        Mockito.verify(mapper).requestToEntity(any());
        Mockito.verify(quizRepository).findById(any());
        Mockito.verify(repository).save(examAnswer);
        Mockito.verify(mapper).entityToResponse(any(ExamAnswer.class));
    }
}
