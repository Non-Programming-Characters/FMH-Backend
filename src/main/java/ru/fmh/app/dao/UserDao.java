package ru.fmh.app.dao;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NonNull UUID id;

    @Column(name = "username", nullable = false)
    @NonNull String username;

    @Column(name = "passwordHash", nullable = false)
    @NonNull String passwordHash;

    @Column(name = "created_at", nullable = false)
    @NonNull Instant createdAt;
}
