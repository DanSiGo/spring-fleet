package com.example.fleet.application.rest;

import com.example.fleet.domain.entity.User;
import com.example.fleet.domain.service.UserService;
import com.example.fleet.domain.to.UserTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/v/user")
@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> create (@RequestBody UserTO userTO){
    return ResponseEntity.ok(userService.createUser(userTO));
  }
}
