package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users/tests")
@RequiredArgsConstructor
public class TestController {

    private final UserTestRepository repository;

    @PostMapping(produces="application/json", consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createTest(@RequestBody TestResultRequest request) {
        UserTest userTest = new UserTest();
        userTest.setId(request.getId());
        userTest.setUserId(request.getUserId());
        userTest.setTotalQuestions(request.getTotalQuestions());
        userTest.setResult(request.getResult());
        userTest.setApprovedAt(request.getApprovedAt());

        repository.save(userTest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<TestResultResponse>> getUserTests(@RequestParam UUID userId) {
        List<UserTest> tests = repository.findByUserId(userId);

        List<TestResultResponse> response = tests.stream()
                .map(test -> new TestResultResponse(
                        test.getId(),
                        test.getUserId(),
                        test.getTotalQuestions(),
                        test.getResult(),
                        test.getApprovedAt()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}