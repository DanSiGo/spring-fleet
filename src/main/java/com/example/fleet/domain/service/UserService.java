package com.example.fleet.domain.service;

import com.example.fleet.domain.entity.User;
import com.example.fleet.domain.exceptions.DomainException;
import com.example.fleet.domain.exceptions.ErrorCode;
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

  public User getById (UUID id) throws DomainException {
    Optional<User> user = userRepository.findById(id);

    // criar exceções
    if (user.isEmpty()){
      throw new DomainException(ErrorCode.USER_NOT_FOUND);
    }

    return user.get();
  }

  public User createUser(UserTO userTO) throws DomainException {

    // criar exceções para tratar erros como user ja existe
    Optional<User> userDB = userRepository.findByName(userTO.getName());
    if (userDB.isPresent()){
      throw new DomainException(ErrorCode.USER_ALREADY_EXISTS);
    }

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

  public User updateUser(UserTO userTO, UUID id) throws DomainException {
    User user = this.getById(id);

    user.setName(userTO.getName());
    user.setRole(userTO.getRole());

    return  userRepository.save(user);
  }

  public void deleteUser(UUID id) throws DomainException {
    User user = this.getById(id);
    userRepository.delete(id);
  }
}
