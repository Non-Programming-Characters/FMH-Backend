package com.example.demo;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "users_tests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTest {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(name = "user_id", columnDefinition = "uuid", nullable = false)
    private UUID userId;

    @Column(name = "total_questions", nullable = false)
    private Integer totalQuestions;

    @Column(nullable = false)
    private Integer result;

    @Column(name = "approved_at", nullable = false)
    private String approvedAt;
}