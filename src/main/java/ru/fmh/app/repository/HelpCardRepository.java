package ru.fmh.app.repository;

import ru.fmh.app.dao.HelpCardDao;
import ru.fmh.app.dao.CargoMainEventCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface HelpCardRepository extends JpaRepository<HelpCardDao, UUID> {
    List<HelpCardDao> findByCategory(CargoMainEventCategory category);
}