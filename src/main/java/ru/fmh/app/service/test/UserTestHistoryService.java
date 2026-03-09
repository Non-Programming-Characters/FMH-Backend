package com.example.demo.service.test;

import com.example.demo.dto.TestUserHistoryDto;

import java.util.List;
import java.util.UUID;

public interface UserTestHistoryService {
    void saveTestHistory(UUID testId, UUID passedUserId, String answerMask);

    List<TestUserHistoryDto> getAllTestHistoryByUserId(UUID userId);
}