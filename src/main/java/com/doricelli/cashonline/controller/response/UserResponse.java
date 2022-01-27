package com.doricelli.cashonline.controller.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserResponse {
  @JsonProperty
  private Long id;
  @JsonProperty
  private String email;
  @JsonProperty
  private String firstName;
  @JsonProperty
  private String lastName;
  @JsonProperty
  private List<LoanResponse> loans;

  @JsonCreator
  public UserResponse(Long id, String email, String firstName, String lastName, List<LoanResponse> loans) {
    this.id = id;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.loans = loans;
  }
}
