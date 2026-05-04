package ru.fmh.app.controller.response;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.fmh.app.dao.CargoMainEventCategory;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class QuickHelpCardResponse {

    @NotNull UUID id;

    @NotNull String title;

    @NotNull String shortDescription;

    @NotNull CargoMainEventCategory category;
}