package com.doricelli.cashonline.repository;

import com.doricelli.cashonline.model.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface LoanRepository extends PagingAndSortingRepository<Loan,Long> {
  Page<Loan> findByUserId(Long userId, Pageable pageable);

  List<Loan> findByUserId(Long userId);
}
