package com.example.demo.repository;

import com.example.demo.UserTest;
import com.example.demo.dao.TestUserHistoryDao;
import com.example.demo.dto.TestUserHistoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserTestHistoryRepository extends JpaRepository<TestUserHistoryDao, UUID> {
    List<TestUserHistoryDao> findAllByUserId(UUID userId);
}