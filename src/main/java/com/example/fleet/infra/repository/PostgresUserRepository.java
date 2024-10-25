package com.example.fleet.infra.repository;

import com.example.fleet.domain.entity.User;
import com.example.fleet.domain.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class PostgresUserRepository implements UserRepository {

  private final SpringDataUserRepository userRepository;

  public PostgresUserRepository(SpringDataUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User save(User entity) {
    return userRepository.save(entity);
  }
}
