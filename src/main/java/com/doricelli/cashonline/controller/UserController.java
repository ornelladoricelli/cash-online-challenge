package com.doricelli.cashonline.controller;

import com.doricelli.cashonline.controller.request.UserRequest;
import com.doricelli.cashonline.controller.response.UserResponse;
import com.doricelli.cashonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping()
  public ResponseEntity<Void> createUser(
    @RequestBody UserRequest userRequest){
    userService.createUser(userRequest);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping(path = "/{id}",
    produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserResponse> getUserById(
    @PathVariable("id") final Long id){
    return ResponseEntity.ok(userService.getUserById(id));
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> deleteUserById(
    @PathVariable("id") final Long id){
    userService.deleteUserById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
