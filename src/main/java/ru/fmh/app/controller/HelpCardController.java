package ru.fmh.app.controller;

import ru.fmh.app.controller.request.CreateHelpCardRequest;
import ru.fmh.app.controller.response.FullHelpCardResponse;
import ru.fmh.app.controller.response.QuickHelpCardResponse;
import ru.fmh.app.dao.HelpCardDao;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fmh.app.service.TestService;
import ru.fmh.app.service.card.HelpCardService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class HelpCardController {

    private final HelpCardService helpCardService;
    private final TestService pdfGenerationService;


    @PostMapping
    public ResponseEntity<FullHelpCardResponse> createCard(@Valid @RequestBody CreateHelpCardRequest request) {
        HelpCardDao createdCardDao = helpCardService.createCard(
                request.getTitle(),
                request.getShortDescription(),
                request.getFullDescription(),
                request.getSources(),
                request.getCategory()
        );
        FullHelpCardResponse response = new FullHelpCardResponse(
                createdCardDao.getId(), createdCardDao.getTitle(),
                createdCardDao.getShortDescription(), createdCardDao.getFullDescription(),
                createdCardDao.getCategory(), createdCardDao.getSources(),
                createdCardDao.getCreatedAt()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(path = "/{cardId}", produces = "application/json")
    public ResponseEntity<FullHelpCardResponse> getCardById(@PathVariable("cardId") UUID cardId) {
        HelpCardDao card = helpCardService.findCardById(cardId);
        FullHelpCardResponse response = new FullHelpCardResponse(
                card.getId(), card.getTitle(),
                card.getShortDescription(), card.getFullDescription(),
                card.getCategory(), card.getSources(),
                card.getCreatedAt()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/{cardId}/quick", produces = "application/json")
    public ResponseEntity<QuickHelpCardResponse> getQuickCardById(@PathVariable("cardId") UUID cardId) {
        HelpCardDao card = helpCardService.findCardById(cardId);
        QuickHelpCardResponse response = new QuickHelpCardResponse(
                card.getId(), card.getTitle(),
                card.getShortDescription(), card.getCategory()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<FullHelpCardResponse>> getAllCardWithPagination(@RequestParam("page") int currentPage, @RequestParam(value = "size", defaultValue = "15", required = false) int size) {
        List<HelpCardDao> cards = helpCardService.findCardsByPagination(currentPage, size);
        List<FullHelpCardResponse> response = cards.stream()
                .map(e ->  new FullHelpCardResponse(
                        e.getId(), e.getTitle(), e.getShortDescription(), e.getFullDescription(),
                        e.getCategory(), e.getSources(), e.getCreatedAt()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/category")
    public ResponseEntity<List<FullHelpCardResponse>> getCardsByCategory(@RequestBody List<String> categories) {
        List<HelpCardDao> cards = helpCardService.findCardsByCategories(categories);
        List<FullHelpCardResponse> response = cards.stream()
                .map(e ->  new FullHelpCardResponse(
                        e.getId(), e.getTitle(), e.getShortDescription(), e.getFullDescription(),
                        e.getCategory(), e.getSources(), e.getCreatedAt()
                ))
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}