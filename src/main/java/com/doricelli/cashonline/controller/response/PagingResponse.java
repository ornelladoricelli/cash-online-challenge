package com.doricelli.cashonline.controller.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString()
@Getter
public class PagingResponse {
  @JsonProperty
  private int page;
  @JsonProperty
  private int size;
  @JsonProperty
  private long total;


  @JsonCreator
  public PagingResponse(int page, int size, long total) {
    this.page = page;
    this.size = size;
    this.total = total;
  }
}
