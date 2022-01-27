package com.doricelli.cashonline.service;

import com.doricelli.cashonline.common.exception.BadDataException;
import com.doricelli.cashonline.common.exception.UserNotFoundException;
import com.doricelli.cashonline.common.util.UserMapper;
import com.doricelli.cashonline.controller.request.UserRequest;
import com.doricelli.cashonline.controller.response.UserResponse;
import com.doricelli.cashonline.model.User;
import com.doricelli.cashonline.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public void createUser(UserRequest userRequest) {
    validateRequestProperties(userRequest);
    User user = userRepository.save(UserMapper.createEntityFromRequest(userRequest));
    log.info("Successfully created new user (id: {})", user.getId());
  }

  public boolean userExistsById(final Long id){
    return userRepository.existsById(id);
  }

  public UserResponse getUserById(final Long id) {
    return userRepository
      .findById(id)
      .map(UserMapper::createUserResponseFromEntity)
      .orElseThrow(() -> new UserNotFoundException("No se encontró usuario con el id " + id));
  }

  @Transactional
  public void deleteUserById(final Long id) {
    try {
      userRepository.deleteById(id);
      log.info("Successfully deleted user with id: {}", id);
    } catch (EmptyResultDataAccessException e) {
      log.warn("Couldn't delete user with id: {}, user doesn't exists", id);
      throw new UserNotFoundException("No se encontró usuario con el id " + id);
    }
  }

  private void validateRequestProperties(UserRequest userRequest) {
    List<String> missingFields = new ArrayList<>();
    if (StringUtils.isBlank(userRequest.getEmail())){
      missingFields.add("email");
    }
    if (StringUtils.isBlank(userRequest.getFirstName())){
      missingFields.add("firstName");
    }
    if (StringUtils.isBlank(userRequest.getLastName())){
      missingFields.add("lastName");
    }
    if (!missingFields.isEmpty()){
      throw new BadDataException("Faltan algunos campos: " + missingFields);
    }
  }
}
