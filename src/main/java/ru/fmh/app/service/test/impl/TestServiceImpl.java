package ru.fmh.app.service.test.impl;

import ru.fmh.app.common.Mapper;
import ru.fmh.app.dao.TestDao;
import ru.fmh.app.dto.TestDto;
import ru.fmh.app.repository.TestRepository;
import ru.fmh.app.service.test.TestService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TestServiceImpl implements TestService {

    Mapper<TestDto, TestDao> mapper;
    TestRepository testRepository;

    @Override
    public TestDto getTestById(UUID testId) {
        return testRepository.findById(testId).map(mapper::mapToDomain)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public int compareWithAnswerMask(UUID testId, String rowAnswers) {

        TestDto test = this.getTestById(testId);

        List<Integer> correctAnswerIndexes = test.getAnswerMask().chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();

        return rowAnswers.chars().map(Character::getNumericValue).boxed()
                .map(index -> index.equals(correctAnswerIndexes.get(index)))
                .filter(state -> state).toList().size();
    }
}