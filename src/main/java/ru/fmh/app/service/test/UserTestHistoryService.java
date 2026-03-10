package ru.fmh.app.service.test;

import ru.fmh.app.dto.TestUserHistoryDto;

import java.util.List;
import java.util.UUID;

public interface UserTestHistoryService {
    void saveTestHistory(UUID testId, UUID passedUserId, String answerMask);

    List<TestUserHistoryDto> getAllTestHistoryByUserId(UUID userId);
}