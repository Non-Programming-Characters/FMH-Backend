package ru.fmh.app.service.card;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.fmh.app.dao.CargoMainEventCategory;
import ru.fmh.app.dao.HelpCardDao;
import ru.fmh.app.repository.HelpCardRepository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HelpCardService {

    @NotNull HelpCardRepository helpCardRepository;

    public HelpCardDao findCardById(UUID cardId) {
        return helpCardRepository.findById(cardId)
                .orElseThrow(() -> new EntityNotFoundException("Help card entity with id %s not found".formatted(cardId)));
    }

    public List<HelpCardDao> findCardsByCategories(List<String> categories) {
        List<CargoMainEventCategory> events = categories.stream()
                .map(source -> CargoMainEventCategory.valueOf(source.toUpperCase()))
                .toList();
        return helpCardRepository.findByCategoryIn(events);
    }

    public HelpCardDao createCard(String title, String shortDesc, String fullDesc, String sources, CargoMainEventCategory category) {
        return helpCardRepository.save(
                HelpCardDao.builder()
                        .title(title)
                        .shortDescription(shortDesc)
                        .fullDescription(fullDesc)
                        .sources(sources)
                        .category(category)
                        .updatedAt(Instant.now())
                        .createdAt(Instant.now())
                        .build()
        );
    }

    public List<HelpCardDao> findCardsByPagination(int page, int contentSize) {
        return helpCardRepository.findAll(PageRequest.of(
            page, contentSize
        )).getContent();
    }
}