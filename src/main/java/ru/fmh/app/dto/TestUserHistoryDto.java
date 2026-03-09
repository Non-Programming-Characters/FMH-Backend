package com.example.demo.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
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
