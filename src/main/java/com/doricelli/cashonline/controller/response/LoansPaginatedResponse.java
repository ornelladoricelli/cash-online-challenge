package com.doricelli.cashonline.controller.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class LoansPaginatedResponse {
  @JsonProperty("items")
  private List<LoanResponse> loanResponses;

  @JsonProperty
  private PagingResponse paging;

  @JsonCreator
  public LoansPaginatedResponse(@JsonProperty("items") List<LoanResponse> loanResponses, PagingResponse paging) {
    this.loanResponses = loanResponses;
    this.paging = paging;
  }

  @Override
  public String toString() {
    return "{" +
      "total_loans=" + loanResponses.size() +
      ", paging=" + paging +
      '}';
  }
}
