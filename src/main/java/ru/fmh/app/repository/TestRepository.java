package ru.fmh.app.repository;

import ru.fmh.app.dao.TestDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TestRepository extends JpaRepository<TestDao, UUID> { }