package com.fonyou.test.app.domain.model.student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Student implements Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private UUID id;

    @Column(name = "name", length = 50, unique = true, nullable = false)
    private String name;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "city", length = 50, nullable = false)
    private String city;

    @Column(name = "timezone", length = 50, nullable = false)
    private String timezone;

    @PrePersist
    private void prePersist() {
        this.id = UUID.randomUUID();
    }
}
