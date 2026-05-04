package ru.fmh.app.dto.material;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MaterialDto {

    @NonNull UUID id;

    @NonNull String title;

    @NonNull String shortDescription;

    @NonNull String fullDescription;

    @NonNull String sources;

    @NonNull Instant createdAt;
}
