package ru.fmh.app.controller.response;

import ru.fmh.app.dao.CargoMainEventCategory;
import ru.fmh.app.dao.SubEventCategory;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelpCardResponse {

    private UUID id;
    private String title;

    @JsonProperty("shortDesc")
    private String shortDesc;

    @JsonProperty("fullDesc")
    private String fullDesc;

    private CargoMainEventCategory category;
    private SubEventCategory subcategory;
    private String sources;

    @JsonProperty("createdAt")
    private String createdAt;
}