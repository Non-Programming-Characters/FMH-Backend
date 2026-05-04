package ru.fmh.app.dto.card;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.fmh.app.dao.CargoMainEventCategory;

import java.time.Instant;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HelpCardDto {

    @NotNull String title;

    @NotNull String shortDescription;

    @NotNull String fullDescription;

    @NotNull CargoMainEventCategory category;

    @NotNull String sources;

    @NotNull Instant createdAt;
}