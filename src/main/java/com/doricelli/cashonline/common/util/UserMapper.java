package com.doricelli.cashonline.common.util;

import com.doricelli.cashonline.controller.request.UserRequest;
import com.doricelli.cashonline.controller.response.UserResponse;
import com.doricelli.cashonline.model.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {
  public static User createEntityFromRequest(UserRequest userRequest){
    return new User(userRequest.getEmail(), userRequest.getFirstName(), userRequest.getLastName());
  }

  public static UserResponse createUserResponseFromEntity(User user) {
    return new UserResponse(user.getId(),
      user.getEmail(), user.getFirstName(), user.getLastName(), LoanMapper.createLoanResponseListFromEntity(user.getLoans()));
  }
}
