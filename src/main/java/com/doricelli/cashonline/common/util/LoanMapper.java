package com.doricelli.cashonline.common.util;

import com.doricelli.cashonline.controller.response.LoanResponse;
import com.doricelli.cashonline.controller.response.LoansPaginatedResponse;
import com.doricelli.cashonline.model.Loan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

import static com.doricelli.cashonline.common.util.PagingHelper.mapPageToPagingResponse;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LoanMapper {

  public static List<LoanResponse> createLoanResponseListFromEntity(List<Loan> loans) {
    return loans.stream().map(l -> new LoanResponse(l.getId(),l.getTotal(),l.getUser().getId())).collect(Collectors.toList());
  }

  public static LoansPaginatedResponse createLoansPaginatedResponseFromPage(Page<Loan> loanPage) {
    return new LoansPaginatedResponse(
      createLoanResponseListFromEntity(loanPage.getContent()),
      mapPageToPagingResponse(loanPage)
    );
  }
}
