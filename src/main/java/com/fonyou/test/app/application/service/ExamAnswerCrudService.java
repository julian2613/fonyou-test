package com.fonyou.test.app.application.service;

import com.fonyou.test.app.application.mapper.ExamAnswerMapper;
import com.fonyou.test.app.application.model.request.exam.answer.ExamAnswerRequest;
import com.fonyou.test.app.application.model.response.exam.answer.ExamAnswerResponse;
import com.fonyou.test.app.domain.model.exam.answer.ExamAnswer;
import com.fonyou.test.app.domain.model.exam.answer.StudentExamAnswer;
import com.fonyou.test.app.domain.model.quiz.Answer;
import com.fonyou.test.app.domain.model.quiz.Question;
import com.fonyou.test.app.domain.model.quiz.Quiz;
import com.fonyou.test.app.domain.repository.ExamAnswerRepository;
import com.fonyou.test.app.domain.repository.QuizRepository;
import com.fonyou.test.shared.model.exception.OperationNotAllowed;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ExamAnswerCrudService {
    private final ExamAnswerMapper mapper;

    private final ExamAnswerRepository repository;

    private final QuizRepository quizRepository;

    public ExamAnswerCrudService(ExamAnswerMapper mapper, ExamAnswerRepository repository, QuizRepository quizRepository) {
        this.mapper = mapper;
        this.repository = repository;
        this.quizRepository = quizRepository;
    }

    public ExamAnswerResponse create(ExamAnswerRequest request) throws OperationNotAllowed {
        ExamAnswer examAnswer = this.mapper.requestToEntity(request);
        Double score = 0.0;

        Optional<Quiz> optionalQuiz = quizRepository.findById(request.getQuiz().getId());
        if (optionalQuiz.isPresent()) {
            Quiz quiz = optionalQuiz.get();

            for (Question question : quiz.getQuestions()) {
                for (StudentExamAnswer studentExamAnswer : examAnswer.getAnswers()) {
                    if (question.getId().equals(studentExamAnswer.getQuestionId())) {
                        Boolean isCorrect = question.getAnswers().stream().filter((Answer answer) -> answer.getId().equals(studentExamAnswer.getAnswerId())).toList().getFirst().getIsCorrect();
                        if (isCorrect) {
                            score += question.getValue();
                        }
                    }
                }
            }
        }

        examAnswer.setScore(score);
        return this.mapper.entityToResponse(this.repository.save(examAnswer));
    }
}
