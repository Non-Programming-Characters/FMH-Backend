package ru.fmh.app.controller.request;

import lombok.experimental.FieldDefaults;
import ru.fmh.app.dao.CargoMainEventCategory;
import ru.fmh.app.dao.SubEventCategory;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HelpCardRequest {

    @NotNull
    UUID id;

    @NotNull
    String title;

    @JsonProperty("shortDesc")
    String shortDesc;

    @JsonProperty("fullDesc")
    String fullDesc;

    @NotNull
    CargoMainEventCategory category;

    SubEventCategory subcategory;

    @JsonProperty("createdAt")
    @NotNull
    String createdAt;
}