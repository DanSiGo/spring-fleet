package com.example.fleet.application.rest;

import com.example.fleet.domain.entity.User;
import com.example.fleet.domain.service.UserService;
import com.example.fleet.domain.to.UserTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> create (UserTO userTO){
    return ResponseEntity.ok(userService.createUser(userTO));
  }
}
