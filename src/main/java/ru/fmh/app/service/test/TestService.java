package com.example.demo.service.test;

import com.example.demo.dto.TestDto;

import java.util.UUID;

public interface TestService {

    TestDto getTestById(UUID testId);

    int compareWithAnswerMask(UUID testId, String rowAnswers);
}