package com.dzmitrykamarou.app.controller;

import com.dzmitrykamarou.app.model.Account;
import com.dzmitrykamarou.app.repository.AccountRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

  @Autowired
  private AccountRepository accountRepository;

  @GetMapping("/accounts")
  public List<Account> getAccounts() {
    return accountRepository.findAll();
  }
}
