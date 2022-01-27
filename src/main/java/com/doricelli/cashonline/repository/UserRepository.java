package com.doricelli.cashonline.repository;

import com.doricelli.cashonline.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
