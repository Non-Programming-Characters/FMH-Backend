package ru.fmh.app.dto.card;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class QuickHelpCardDto {

    @NotNull String title;

    @NotNull String shortDescription;

    @NotNull Instant createdAt;
}
