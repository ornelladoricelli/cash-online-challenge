package com.doricelli.cashonline.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.jdbc.Sql;

@Profile("test")
@SpringBootTest()
class UserRepositoryTest {
  @Autowired private LoanRepository loanRepository;
  @Autowired private UserRepository userRepository;

  @Test
  @Sql(scripts = {"/test_data.sql"})
  void deleteLoansWhenDeleteRelatedUser(){
    Assertions.assertFalse(loanRepository.findByUserId(2L).isEmpty());
    userRepository.deleteById(2L);
    Assertions.assertTrue(loanRepository.findByUserId(2L).isEmpty());
  }
}
