package ru.fmh.app.controller.response;

import lombok.experimental.FieldDefaults;
import ru.fmh.app.dao.CargoMainEventCategory;
import ru.fmh.app.dao.SubEventCategory;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HelpCardResponse {

    UUID id;
    String title;

    @JsonProperty("shortDesc")
     String shortDesc;

    @JsonProperty("fullDesc")
    String fullDesc;

    CargoMainEventCategory category;
    SubEventCategory subcategory;
    String sources;

    @JsonProperty("createdAt")
    String createdAt;
}