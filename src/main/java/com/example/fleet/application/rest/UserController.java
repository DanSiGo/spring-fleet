package com.example.fleet.application.rest;

import com.example.fleet.domain.entity.User;
import com.example.fleet.domain.service.UserService;
import com.example.fleet.domain.to.PageTO;
import com.example.fleet.domain.to.PaginationTO;
import com.example.fleet.domain.to.UserTO;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping
  public ResponseEntity<PageTO<User>> getAll (
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size
  ) {
    PaginationTO paginationTO = new PaginationTO(page, size);
    Map<String, Object> params = new HashMap<>();
    paginationTO.setParams(params);

    return ResponseEntity.ok(userService.getAll(paginationTO));
  }

  @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> update(@RequestBody UserTO userTO, @PathVariable("id") UUID id) {
    return ResponseEntity.ok(userService.updateUser(userTO, id));
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<User> delete(@RequestBody @PathVariable("id") UUID id) {
    userService.deleteUser(id);
    return ResponseEntity.ok().build();
  }
}
