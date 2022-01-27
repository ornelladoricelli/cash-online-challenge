package com.doricelli.cashonline.service;


import com.doricelli.cashonline.common.exception.BadDataException;
import com.doricelli.cashonline.common.exception.UserNotFoundException;
import com.doricelli.cashonline.model.User;
import com.doricelli.cashonline.controller.request.UserRequest;
import com.doricelli.cashonline.controller.response.UserResponse;
import com.doricelli.cashonline.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {
  public static final String EMAIL = "ornella@mail.com";
  public static final String FIRST_NAME = "Ornella";
  public static final String LAST_NAME = "Doricelli";
  private final UserService userService;
  private final UserRepository userRepository;

  public UserServiceTest() {
    this.userRepository = mock(UserRepository.class);
    this.userService = new UserService(userRepository);
  }

  @Test
  void createUserOk(){
    UserRequest userRequest = givenAUserRequest();
    whenCallingCreateUserMethod(userRequest);
    thenShouldSaveUserInRepository();
  }

  @Test
  void createUserNoOk(){
    UserRequest userRequest = givenAUserRequestWithMissingProperties();
    assertThrows(
        BadDataException.class,
        ()-> whenCallingCreateUserMethod(userRequest));
    thenShouldNotSaveUserInDatabase();
  }

  @Test
  void getUserByIdOk(){
    givenAUserInDatabase();
    UserResponse userResponse = whenCallingGetUserById();
    thenShouldReturnAUserResponse(userResponse);
  }

  @Test
  void getUserByIdNoOk(){
    givenNoUserInDatabase();
    assertThrows(UserNotFoundException.class, this::whenCallingGetUserById);
  }

  @Test
  void deleteUserByIdNoOk(){
    givenNoUserToDeleteInDatabase();
    assertThrows(UserNotFoundException.class, this::whenCallingDeleteUserById);
  }

  private void whenCallingDeleteUserById() {
    userService.deleteUserById(1L);
  }

  private void givenNoUserToDeleteInDatabase() {
    doThrow(new EmptyResultDataAccessException(1)).when(userRepository).deleteById(any());
  }

  private void givenNoUserInDatabase() {
    when(userRepository.findById(any())).thenReturn(Optional.empty());
  }

  private void thenShouldReturnAUserResponse(UserResponse userResponse) {
    assertNotNull(userResponse);
  }

  private UserResponse whenCallingGetUserById() {
    return userService.getUserById(1L);
  }

  private void givenAUserInDatabase() {
    User user = User.buildForTest(1L, EMAIL, FIRST_NAME, LAST_NAME);
    when(userRepository.findById(any())).thenReturn(Optional.of(user));
  }

  private void thenShouldNotSaveUserInDatabase() {
    verifyNoInteractions(userRepository);
  }

  private void thenShouldSaveUserInRepository() {
    verify(userRepository).save(any());
  }

  private void whenCallingCreateUserMethod(UserRequest userRequest) {
    userService.createUser(userRequest);
  }

  private UserRequest givenAUserRequest() {
    return new UserRequest(EMAIL, FIRST_NAME, LAST_NAME);
  }

  private UserRequest givenAUserRequestWithMissingProperties() {
    return new UserRequest(EMAIL, "", null);
  }
}