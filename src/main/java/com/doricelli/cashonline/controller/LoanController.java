package com.doricelli.cashonline.controller;

import com.doricelli.cashonline.controller.response.LoansPaginatedResponse;
import com.doricelli.cashonline.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/loans")
public class LoanController {
  private final LoanService loanService;

  @Autowired
  public LoanController(LoanService loanService) {
    this.loanService = loanService;
  }

  @GetMapping
  public ResponseEntity<LoansPaginatedResponse> getLoans(
    @RequestParam(value = "user_id", required = false) Long userId,
    @RequestParam(value = "page") int page,
    @RequestParam(value = "size") int size){
    LoansPaginatedResponse response;
    if (null != userId){
      response = loanService.getUserLoansPaginated(userId,page,size);
    } else {
      response = loanService.getLoansPaginated(page,size);
    }
    return ResponseEntity.ok(response);
  }
}
