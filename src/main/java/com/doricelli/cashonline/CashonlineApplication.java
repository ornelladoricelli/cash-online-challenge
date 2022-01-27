package com.doricelli.cashonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CashonlineApplication {

  public static void main(String[] args) {
    SpringApplication.run(CashonlineApplication.class, args);
  }

}
