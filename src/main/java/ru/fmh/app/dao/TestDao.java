package ru.fmh.app.dao;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tests")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestDao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    UUID id;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "answer_mask", nullable = false)
    String answerMask;

    @Column(name = "question_text", length = 5000)
    String questions;

    @Column(name = "created_at", nullable = false)
    Instant createdAt;
}