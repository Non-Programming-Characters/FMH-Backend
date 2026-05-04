package ru.fmh.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fmh.app.dao.UserDao;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserDao, UUID> {
    Optional<UserDao> findByUsername(String username);
}
