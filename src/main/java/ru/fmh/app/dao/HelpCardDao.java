package ru.fmh.app.dao;

import lombok.experimental.FieldDefaults;
import ru.fmh.app.dao.CargoMainEventCategory;
import ru.fmh.app.dao.SubEventCategory;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "help_cards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HelpCardDao {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(name = "short_desc", columnDefinition = "TEXT")
    private String shortDesc;

    @Column(name = "full_desc", columnDefinition = "TEXT")
    private String fullDesc;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CargoMainEventCategory category;

    @Enumerated(EnumType.STRING)
    @Column(name = "subcategory")
    private SubEventCategory subcategory;

    @Column(nullable = false)
    private String sources;

    @Column(name = "created_at", nullable = false)
    private String createdAt;
}