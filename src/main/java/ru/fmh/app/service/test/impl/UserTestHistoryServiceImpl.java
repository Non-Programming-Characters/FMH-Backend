package com.example.demo.service.test.impl;

import com.example.demo.common.Mapper;
import com.example.demo.dao.TestUserHistoryDao;
import com.example.demo.dto.TestUserHistoryDto;
import com.example.demo.repository.UserTestHistoryRepository;
import com.example.demo.service.test.TestService;
import com.example.demo.service.test.UserTestHistoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

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