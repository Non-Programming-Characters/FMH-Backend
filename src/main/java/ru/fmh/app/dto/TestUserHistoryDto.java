package ru.fmh.app.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TestUserHistoryDto {

    UUID id;

    UUID testId;

    UUID passedUserId;

    int result;

    Instant createdAt;
}