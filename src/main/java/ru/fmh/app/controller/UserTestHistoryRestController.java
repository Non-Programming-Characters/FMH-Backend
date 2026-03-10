package ru.fmh.app.controller;

import ru.fmh.app.controller.request.TestHistoryUploadRequest;
import ru.fmh.app.controller.response.GetTestHistoryResponse;
import ru.fmh.app.controller.response.TestHistoryUploadResponse;
import ru.fmh.app.service.test.TestService;
import ru.fmh.app.service.test.UserTestHistoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/test/history")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserTestHistoryRestController {

    TestService testService;
    UserTestHistoryService userTestHistoryService;

    @GetMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<GetTestHistoryResponse>> getTestHistory(@RequestParam("userId") UUID userId) {
        return ResponseEntity.ok(
                userTestHistoryService.getAllTestHistoryByUserId(userId).stream()
                        .map(dto -> new GetTestHistoryResponse(
                                        testService.getTestById(dto.getTestId()).getTitle(),
                                        dto.getResult(),
                                        dto.getCreatedAt()
                                )
                        ).toList()
        );
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<TestHistoryUploadResponse> uploadTestHistory(@RequestBody TestHistoryUploadRequest testHistoryUploadRequest) {
        userTestHistoryService.saveTestHistory(
                testHistoryUploadRequest.getTestId(),
                testHistoryUploadRequest.getUserId(),
                testHistoryUploadRequest.getAnswerMask()
        );
        return ResponseEntity.ok(new TestHistoryUploadResponse());
    }
}