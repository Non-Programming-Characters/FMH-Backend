package ru.fmh.app.dao;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "help_cards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MaterialDao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NonNull UUID id;

    @Column(nullable = false)
    String title;

    @Column(name = "short_desc", nullable = false)
    String shortDescription;

    @Column(name = "full_desc", nullable = false)
    String fullDescription;

    @Column(nullable = false)
    String sources;

    @Column(name = "created_at", nullable = false)
    Instant createdAt;
}
