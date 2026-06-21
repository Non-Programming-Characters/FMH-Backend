package ru.fmh.app.dao;

import lombok.experimental.FieldDefaults;
import jakarta.persistence.*;
import lombok.*;

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
public class HelpCardDao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid")
    UUID id;

    @Column(nullable = false)
    String title;

    @Column(name = "short_desc", length = 5000, nullable = false)
    String shortDescription;

    @Column(name = "full_desc", length = 5000, nullable = false)
    String fullDescription;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    CargoMainEventCategory category;

    @Column(nullable = false)
    String sources;

    @Column(name = "updated_at", nullable = false)
    Instant updatedAt;

    @Column(name = "created_at", nullable = false)
    Instant createdAt;
}