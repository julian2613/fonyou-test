package com.fonyou.test.app.domain.model.exam;

import com.fonyou.test.app.domain.model.quiz.Quiz;
import com.fonyou.test.app.domain.model.student.Student;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Exam implements Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private UUID id;

    @Column(name = "presentation_date", nullable = false)
    private LocalDateTime presentationDate;

    @Column(name = "timezone", length = 50, nullable = false)
    private String timezone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @ManyToMany
    @JoinTable(name = "exam_student", joinColumns = @JoinColumn(name = "exam_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;

    @PrePersist
    private void prePersist() {
        this.id = UUID.randomUUID();
    }
}
