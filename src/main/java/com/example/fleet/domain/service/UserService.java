package com.example.fleet.domain.service;

import com.example.fleet.domain.entity.User;
import com.example.fleet.domain.repository.UserRepository;
import com.example.fleet.domain.to.UserTO;

public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
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



}
