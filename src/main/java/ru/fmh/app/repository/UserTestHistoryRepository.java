package ru.fmh.app.repository;

import ru.fmh.app.dao.TestUserHistoryDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserTestHistoryRepository extends JpaRepository<TestUserHistoryDao, UUID> {
    List<TestUserHistoryDao> findAllByUserId(UUID userId);
}