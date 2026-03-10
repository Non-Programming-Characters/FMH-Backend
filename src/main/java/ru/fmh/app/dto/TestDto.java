package ru.fmh.app.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TestDto {

    UUID id;

    String title;

    List<String> questions;

    /**
     * Структура:
     * - 131...
     * Означает:
     * Вопрос 1: верный ответ - 1
     * Вопрос 2: верный ответ - 3
     * Вопрос 3: верный ответ - 1
     */
    String answerMask;
}