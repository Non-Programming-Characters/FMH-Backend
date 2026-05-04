package ru.fmh.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import ru.fmh.app.dao.HelpCardDao;
import ru.fmh.app.dao.CargoMainEventCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HelpCardRepository extends JpaRepository<HelpCardDao, UUID> {

    List<HelpCardDao> findByCategoryIn(List<CargoMainEventCategory> categories);

    @Query(
            "SELECT card FROM HelpCardDao card WHERE " +
            "LOWER(card.title) LIKE LOWER(CONCAT('%', :searchText, '%'))" +
            "OR LOWER(card.shortDescription) LIKE LOWER(CONCAT('%', :searchText, '%'))" +
            "OR LOWER(card.fullDescription) LIKE LOWER(CONCAT('%', :searchText, '%'))" +
            "OR LOWER(card.sources) LIKE LOWER(CONCAT('%', :searchText, '%'))"
    )
    List<HelpCardDao> findByContainsContent(String content);
}