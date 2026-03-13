package ru.fmh.app.controller.request;

import ru.fmh.app.dao.CargoMainEventCategory;
import ru.fmh.app.dao.SubEventCategory;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelpCardRequest {

    @NotNull
    private UUID id;

    @NotNull
    private String title;

    @JsonProperty("shortDesc")
    private String shortDesc;

    @JsonProperty("fullDesc")
    private String fullDesc;

    @NotNull
    private CargoMainEventCategory category;

    private SubEventCategory subcategory;

    @JsonProperty("createdAt")
    @NotNull
    private String createdAt;
}