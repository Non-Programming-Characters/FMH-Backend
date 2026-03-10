package ru.fmh.app.service.test.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.fmh.app.common.Mapper;
import ru.fmh.app.dao.TestUserHistoryDao;
import ru.fmh.app.dto.TestUserHistoryDto;
import ru.fmh.app.repository.UserTestHistoryRepository;
import ru.fmh.app.service.test.TestService;
import ru.fmh.app.service.test.UserTestHistoryService;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserTestHistoryServiceImpl implements UserTestHistoryService {

    Mapper<TestUserHistoryDto, TestUserHistoryDao> mapper;

    TestService testService;
    UserTestHistoryRepository userTestHistoryRepository;

    @Override
    public void saveTestHistory(UUID testId, UUID passedUserId, String answerMask) {
        TestUserHistoryDao testDao = TestUserHistoryDao.builder()
                .id(UUID.randomUUID())
                .testId(testId)
                .passedUserId(passedUserId)
                .result(testService.compareWithAnswerMask(testId, answerMask))
                .createdAt(Instant.now())
                .build();

        userTestHistoryRepository.save(testDao);
    }

    @Override
    public List<TestUserHistoryDto> getAllTestHistoryByUserId(UUID userId) {
        return userTestHistoryRepository.findAllByUserId(userId)
                .stream()
                .map(mapper::mapToDomain)
                .toList();
    }
}