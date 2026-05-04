package ru.fmh.app.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.fmh.app.dao.TestDao;
import ru.fmh.app.dao.TestUserHistoryDao;
import ru.fmh.app.repository.TestRepository;
import ru.fmh.app.repository.UserTestHistoryRepository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TestService {

    @NonNull TestRepository testRepository;
    @NonNull UserTestHistoryRepository userTestHistoryRepository;

    public TestDao createTest(String title, List<String> questions, String answerMask) {
        TestDao preparedTestDao = TestDao.builder()
                                .title(title)
                                .questions(questions)
                                .answerMask(answerMask)
                                .createdAt(Instant.now())
                                .build();

        return testRepository.save(preparedTestDao);
    }

    public TestDao getTest(UUID testId) {
        return testRepository.findById(testId)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<TestDao> getAllTests() {
        return testRepository.findAll();
    }

    public void submitTest(UUID userId, UUID testId, String answers) {
        TestDao testDao = this.getTest(testId);

        String correctAnswerMask = testDao.getAnswerMask();
        long invalidAnswer = IntStream.range(0, correctAnswerMask.length())
                .filter(i -> correctAnswerMask.charAt(i) != answers.charAt(i))
                .count();

        userTestHistoryRepository.save(
                TestUserHistoryDao.builder()
                        .testId(testDao.getId())
                        .passedUserId(userId)
                        .result((int) (correctAnswerMask.length() - invalidAnswer))
                        .createdAt(Instant.now())
                        .build()
        );
    }
}
