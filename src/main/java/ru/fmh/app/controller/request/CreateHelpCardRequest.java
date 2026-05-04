package ru.fmh.app.controller.request;

import lombok.experimental.FieldDefaults;
import ru.fmh.app.dao.CargoMainEventCategory;
import ru.fmh.app.dao.SubEventCategory;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateHelpCardRequest {

    @NotNull
    String title;

    @NotNull
    String shortDescription;

    @NotNull
    String fullDescription;

    @NotNull
    CargoMainEventCategory category;

    @NotNull
    String sources;
}