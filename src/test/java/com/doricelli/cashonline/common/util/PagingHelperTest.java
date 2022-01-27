package com.doricelli.cashonline.common.util;

import com.doricelli.cashonline.common.exception.RangeNotSatisfiableException;
import com.doricelli.cashonline.model.Loan;
import com.doricelli.cashonline.model.User;
import com.doricelli.cashonline.controller.response.PagingResponse;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class PagingHelperTest {

  @Test
  void mapPageToPagingResponse(){
    Page<Loan> loanPage = givenALoanPageWithOneElement();
    PagingResponse pagingResponse = whenMappingPageToPagingResponse(loanPage);
    thenPagingResponseShouldHaveTheRightValues(pagingResponse);
  }

  @Test
  void getPageable(){
    Pageable pageable = whenGettingPageableForFirstPage();
    thenPageablePageShouldBeZero(pageable);
  }

  @Test
  void verifyPageBounds(){
    assertThrows(RangeNotSatisfiableException.class,
      () -> PagingHelper.verifyPageBounds(1,1));
  }

  private void thenPageablePageShouldBeZero(Pageable pageable) {
    assertEquals(0, pageable.getPageNumber());
  }

  private Pageable whenGettingPageableForFirstPage() {
    return PagingHelper.getPageable(1, 5, "id");
  }

  private void thenPagingResponseShouldHaveTheRightValues(PagingResponse pagingResponse) {
    assertEquals(1, pagingResponse.getPage());
    assertEquals(1, pagingResponse.getTotal());
    assertEquals(1, pagingResponse.getSize());
  }

  private PagingResponse whenMappingPageToPagingResponse(Page<Loan> loanPage) {
    return PagingHelper.mapPageToPagingResponse(loanPage);
  }

  private PageImpl<Loan> givenALoanPageWithOneElement() {
    return new PageImpl<>(
      Collections.singletonList(
        Loan.buildForTest(
          1L,
          BigDecimal.valueOf(10000L),
          User.buildForTest(
            1L,
            "hola@hola.com",
            "Juan",
            "Perez")
        )
      )
    );
  }
}