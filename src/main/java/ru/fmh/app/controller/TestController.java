package ru.fmh.app.controller;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fmh.app.controller.request.CreateTestRequest;
import ru.fmh.app.dao.TestDao;
import ru.fmh.app.dto.test.TestDto;
import ru.fmh.app.service.TestService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tests")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TestController {

    @NonNull TestService testService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<TestDto>> getTests() {
        List<TestDto> mappedTestDto = testService.getAllTests().stream().map(testDao -> new TestDto(
                testDao.getId(),
                testDao.getTitle(),
                testDao.getQuestions(),
                testDao.getAnswerMask()
        )).toList();
        return ResponseEntity.ok(mappedTestDto);
    }

    @GetMapping(path = "/{testId}", produces = "application/json")
    public ResponseEntity<TestDto> getTest(@PathVariable("testId") UUID testId) {
        TestDao testDao = testService.getTest(testId);
        TestDto mappedTestDto = new TestDto(
                testDao.getId(),
                testDao.getTitle(),
                testDao.getQuestions(),
                testDao.getAnswerMask()
        );
        return ResponseEntity.ok(mappedTestDto);
    }

    @PostMapping(path = "/{testId}/submit", produces = "application/json")
    public ResponseEntity<?> submitTestResult(@PathVariable("testId") UUID testId, @RequestBody String answers) {
        testService.submitTest(UUID.randomUUID(), testId, answers);
        return ResponseEntity.ok().build();
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<TestDto> createTest(@RequestBody CreateTestRequest createTestRequest) {
        TestDao testDao = testService.createTest(
                createTestRequest.getTitle(),
                createTestRequest.getQuestions(),
                createTestRequest.getAnswerMask()
        );
        TestDto mappedTestDto = new TestDto(
                testDao.getId(),
                testDao.getTitle(),
                testDao.getQuestions(),
                testDao.getAnswerMask()
        );
        return ResponseEntity.ok(mappedTestDto);
    }
}
