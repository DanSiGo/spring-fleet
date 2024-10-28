package com.example.fleet.infra.repository;

import com.example.fleet.domain.entity.User;
import com.example.fleet.domain.repository.UserRepository;
import com.example.fleet.domain.to.PageTO;
import com.example.fleet.domain.to.PaginationTO;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

  @Override
  public PageTO<User> findAll(PaginationTO paginationTO) {
    Pageable pageable = PageRequest.of(paginationTO.getPage(), paginationTO.getSize());
    Page<User> users = userRepository.findAll(pageable);
    return new PageTO<>(users.getContent(), users.getTotalElements(), users.getNumber(),
        users.getSize());
  }

  @Override
  public Optional<User> findById(UUID id) {
    return userRepository.findById(id);
  }

  @Override
  public Optional<User> delete(UUID id) {
    Optional<User> user = userRepository.findById(id);
    user.ifPresent(userRepository::delete);
    return user;
  }


}
