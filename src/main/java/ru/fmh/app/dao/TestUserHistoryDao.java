package ru.fmh.app.dao;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "user_tests_history")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TestUserHistoryDao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    UUID id;

    @Column(name = "test_id", nullable = false)
    UUID testId;

    @Column(name = "passed_user_id", nullable = false)
    UUID passedUserId;

    @Column(name = "result", nullable = false)
    int result;

    @Column(name = "created_at", nullable = false)
    Instant createdAt;
}