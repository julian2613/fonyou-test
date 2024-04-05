package com.fonyou.test.app.domain.model.exam.answer;

import com.fonyou.test.app.domain.model.quiz.Quiz;
import com.fonyou.test.app.domain.model.student.Student;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class ExamAnswer implements Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private UUID id;

    @Column(name = "score", nullable = false, updatable = false)
    private Double score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "questions", columnDefinition = "JSON", nullable = false)
    private List<StudentExamAnswer> answers;

    @PrePersist
    private void prePersist() {
        this.id = UUID.randomUUID();
    }
}
