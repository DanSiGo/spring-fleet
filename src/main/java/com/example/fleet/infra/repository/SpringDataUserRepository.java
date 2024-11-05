package com.example.fleet.infra.repository;

import com.example.fleet.domain.entity.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUserRepository extends JpaRepository<User, UUID> {
  Optional<User> findByName(String name);
}
