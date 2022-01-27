package com.doricelli.cashonline.controller.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class LoanResponse {
  @JsonProperty
  private Long id;
  @JsonProperty
  private BigDecimal total;
  @JsonProperty
  private Long userId;

  @JsonCreator
  public LoanResponse(Long id, BigDecimal total, Long userId) {
    this.id = id;
    this.total = total;
    this.userId = userId;
  }
}
