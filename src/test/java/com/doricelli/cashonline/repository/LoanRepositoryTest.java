package com.doricelli.cashonline.repository;

import com.doricelli.cashonline.model.Loan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

@Profile("test")
@SpringBootTest
class LoanRepositoryTest {
  public static final int PAGE_NUMBER = 0;
  public static final int PAGE_SIZE = 5;
  public static final String SORT_PARAM = "id";
  @Autowired private LoanRepository loanRepository;


  @Test
  @Sql(scripts = {"/test_data.sql"})
  void findByUserId() {
    Page<Loan> loansByUserId = loanRepository.findByUserId(1L, PageRequest.of(PAGE_NUMBER , PAGE_SIZE, Sort.by(SORT_PARAM)));
    Assertions.assertNotNull(loansByUserId);
    Assertions.assertEquals(1L, loansByUserId.getTotalPages());
    Assertions.assertEquals(3L, loansByUserId.getTotalElements());
  }
}