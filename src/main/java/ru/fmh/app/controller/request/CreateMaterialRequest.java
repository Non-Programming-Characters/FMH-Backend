package ru.fmh.app.controller.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateMaterialRequest {

    @NonNull String title;

    @NonNull String shortDescription;

    @NonNull String fullDescription;

    @NonNull String sources;
}
