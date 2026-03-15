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
    @Column(columnDefinition = "uuid")
    UUID id;

    @Column(nullable = false)
    String title;

    @Column(name = "short_desc", columnDefinition = "TEXT")
    String shortDesc;

    @Column(name = "full_desc", columnDefinition = "TEXT")
    String fullDesc;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    CargoMainEventCategory category;

    @Enumerated(EnumType.STRING)
    @Column(name = "subcategory")
    SubEventCategory subcategory;

    @Column(nullable = false)
    String sources;

    @Column(name = "created_at", nullable = false)
    Instant createdAt;
}