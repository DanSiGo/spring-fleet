package com.example.fleet.domain.service;

import com.example.fleet.domain.entity.User;
import com.example.fleet.domain.repository.UserRepository;
import com.example.fleet.domain.to.PageTO;
import com.example.fleet.domain.to.PaginationTO;
import com.example.fleet.domain.to.UserTO;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User getById (UUID id){
    Optional<User> user = userRepository.findById(id);

    // criar exceções

    return user.get();
  }

  public User createUser(UserTO userTO) {

    // criar exceções para tratar erros como user ja existe

    User user = User.builder()
        .name(userTO.getName())
        .role(userTO.getRole())
        .build();

    // quando criar autenticação, incluir setpassword

    return userRepository.save(user);
  }

  public PageTO<User> getAll(PaginationTO paginationTO) {
    return userRepository.findAll(paginationTO);
  }

  public User updateUser(UserTO userTO, UUID id){
    User user = this.getById(id);

    user.setName(userTO.getName());
    user.setRole(userTO.getRole());

    return  userRepository.save(user);
  }

  public void deleteUser(UUID id) {
    User user = this.getById(id);

    userRepository.save(user);
  }
}
