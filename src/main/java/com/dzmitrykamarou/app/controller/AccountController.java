package com.dzmitrykamarou.app.controller;

import com.dzmitrykamarou.app.exception.ResourceNotFoundException;
import com.dzmitrykamarou.app.model.Account;
import com.dzmitrykamarou.app.repository.AccountRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

  @Autowired
  private AccountRepository accountRepository;

  @GetMapping("/accounts")
  public List<Account> getAccounts() {
    return accountRepository.findAll(Sort.by(Direction.ASC, "id"));
  }

  @PostMapping("/accounts")
  public Account postAccounts(@Valid @RequestBody Account account) {
    return accountRepository.save(account);
  }

  @DeleteMapping("/accounts/{accountId}")
  public ResponseEntity<?> deleteAccounts(@PathVariable Long accountId) {
    return accountRepository.findById(accountId).map(account -> {
      accountRepository.delete(account);
      return ResponseEntity.ok().build();
    }).orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + accountId));
  }
}
