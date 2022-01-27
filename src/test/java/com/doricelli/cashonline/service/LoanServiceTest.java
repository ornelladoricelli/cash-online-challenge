package com.doricelli.cashonline.service;

import com.doricelli.cashonline.common.exception.UserNotFoundException;
import com.doricelli.cashonline.repository.LoanRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoanServiceTest {
  private final LoanService loanService;
  private final UserService userService;
  private final LoanRepository loanRepository;

  public LoanServiceTest() {
    this.userService = mock(UserService.class);
    this.loanRepository = mock(LoanRepository.class);
    this.loanService = new LoanService(loanRepository,userService);
  }

  @Test
  void getUserLoansPaginatedNonExistentUser(){
    givenNonExistentUserInDatabase();
    assertThrows(UserNotFoundException.class, () -> loanService.getUserLoansPaginated(3L, 1,5));
  }

  private void givenNonExistentUserInDatabase() {
    when(userService.userExistsById(anyLong())).thenReturn(false);
  }
}
