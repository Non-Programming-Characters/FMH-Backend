package ru.fmh.app.service.test;

import ru.fmh.app.dto.TestDto;

import java.util.UUID;

public interface TestService {

    TestDto getTestById(UUID testId);

    int compareWithAnswerMask(UUID testId, String rowAnswers);
}