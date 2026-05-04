package ru.fmh.app.controller;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fmh.app.dto.test.TestUserHistoryDto;
import ru.fmh.app.service.ProfileService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProfileController {

    @NotNull ProfileService profileService;

    @GetMapping(value = "/history/cards", produces = "application/json")
    public ResponseEntity<List<TestUserHistoryDto>> getUserFullHistory(@AuthenticationPrincipal Authentication authentication) {


        return ResponseEntity.ok().build();
    }
}
