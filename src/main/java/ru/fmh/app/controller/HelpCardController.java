package ru.fmh.app.controller;

import ru.fmh.app.controller.request.HelpCardRequest;
import ru.fmh.app.controller.response.HelpCardResponse;
import ru.fmh.app.dao.CargoMainEventCategory;
import ru.fmh.app.dao.HelpCardDao;
import ru.fmh.app.repository.HelpCardRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class HelpCardController {

    private final HelpCardRepository repository;

    // POST /api/v1/cards
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<HelpCardResponse> createCard(@Valid @RequestBody HelpCardRequest request) {
        HelpCardDao card = new HelpCardDao();
        repository.save(
                HelpCardDao.builder().id(request.getId())
                        .title(request.getTitle())
                        .shortDesc(request.getShortDesc())
                        .fullDesc(request.getFullDesc())
                        .category(request.getCategory())
                        .subcategory(request.getSubcategory())
                        .createdAt(request.getCreatedAt())
                        .build()
        );

        HelpCardResponse response = mapToResponse(card);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // GET /api/v1/cards - Все карточки
    @GetMapping
    public ResponseEntity<List<HelpCardResponse>> getAllCards() {
        List<HelpCardDao> cards = repository.findAll();
        List<HelpCardResponse> response = cards.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    // GET /api/v1/cards?category=ACCIDENT - Фильтрация по категории
    @GetMapping(params = "category")
    public ResponseEntity<List<HelpCardResponse>> getCardsByCategory(
            @RequestParam CargoMainEventCategory category) {

        List<HelpCardDao> cards = repository.findByCategory(category);
        List<HelpCardResponse> response = cards.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    // Маппинг Entity -> DTO
    private HelpCardResponse mapToResponse(HelpCardDao card) {
        return new HelpCardResponse(
                card.getId(),
                card.getTitle(),
                card.getShortDesc(),
                card.getFullDesc(),
                card.getCategory(),
                card.getSubcategory(),
                card.getSources(),
                card.getCreatedAt()
        );
    }
}