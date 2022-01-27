package com.doricelli.cashonline.common.util;

import com.doricelli.cashonline.common.exception.RangeNotSatisfiableException;
import com.doricelli.cashonline.controller.response.PagingResponse;
import com.doricelli.cashonline.model.Loan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PagingHelper {
  public static final int PAGE_OFFSET = 1;

  public static PagingResponse mapPageToPagingResponse(Page<Loan> loanPage) {
    return
      new PagingResponse(
        loanPage.getNumber() + PAGE_OFFSET,
        loanPage.getSize(),
        loanPage.getTotalPages()
      );
  }

  public static Pageable getPageable(int page, int size, String sortParam) {
    return PageRequest.of(page - PAGE_OFFSET , size, Sort.by(sortParam));
  }

  public static void verifyPageBounds(int loanPageNumber, int loanTotalPages){
    if (loanPageNumber + PAGE_OFFSET > loanTotalPages){
     throw new RangeNotSatisfiableException("El numero de pagina supera el total de paginas disponible: " + loanTotalPages);
    }
  }
}
