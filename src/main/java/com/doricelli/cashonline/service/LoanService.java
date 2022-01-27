package com.doricelli.cashonline.service;

import com.doricelli.cashonline.common.exception.UserNotFoundException;
import com.doricelli.cashonline.common.util.LoanMapper;
import com.doricelli.cashonline.common.util.PagingHelper;
import com.doricelli.cashonline.controller.response.LoansPaginatedResponse;
import com.doricelli.cashonline.model.Loan;
import com.doricelli.cashonline.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import static com.doricelli.cashonline.common.util.PagingHelper.*;

@Service
public class LoanService {
  public static final String ID = "id";
  private final LoanRepository loanRepository;
  private final UserService userService;

  @Autowired
  public LoanService(LoanRepository loanRepository, UserService userService) {
    this.loanRepository = loanRepository;
    this.userService = userService;
  }

  public LoansPaginatedResponse getUserLoansPaginated(Long userId, int page, int size) {
    if (userService.userExistsById(userId)){
      Page<Loan> loanPage = loanRepository.findByUserId(userId, getPageable(page, size, ID));
      verifyPageBounds(loanPage);
      return LoanMapper.createLoansPaginatedResponseFromPage(loanPage);
    }
    throw new UserNotFoundException("No se puede filtrar, id de usuario inexistente");
  }

  public LoansPaginatedResponse getLoansPaginated(int page, int size) {
    Page<Loan> loanPage = loanRepository.findAll(getPageable(page, size, ID));
    verifyPageBounds(loanPage);
    return LoanMapper.createLoansPaginatedResponseFromPage(loanPage);
  }

  private void verifyPageBounds(Page<Loan> loanPage) {
    PagingHelper.verifyPageBounds(loanPage.getNumber(), loanPage.getTotalPages());
  }
}
