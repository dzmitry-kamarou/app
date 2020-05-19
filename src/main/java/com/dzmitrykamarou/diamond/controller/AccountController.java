package com.dzmitrykamarou.diamond.controller;

import com.dzmitrykamarou.diamond.exception.ResourceNotFoundException;
import com.dzmitrykamarou.diamond.model.Account;
import com.dzmitrykamarou.diamond.repository.AccountRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController extends BaseController {

  @Autowired
  private AccountRepository accountRepository;

  @GetMapping(value = API + V1 + "/accounts", produces = {"application/json"})
  public List<Account> getAccounts() {
    return accountRepository.findAll(Sort.by(Direction.ASC, "id"));
  }

  @GetMapping(value = API + V1 + "/accounts/{accountId}", produces = {"application/json"})
  public ResponseEntity<?> getAccount(@PathVariable Long accountId) {
    return accountRepository.findById(accountId)
        .map(account -> new ResponseEntity<>(account, HttpStatus.OK))
        .orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + accountId));
  }

  @PostMapping(API + V1 + "/accounts")
  public Account postAccounts(@Valid @RequestBody Account account) {
    return accountRepository.save(account);
  }

  @DeleteMapping(API + V1 + "/accounts/{accountId}")
  public ResponseEntity<?> deleteAccounts(@PathVariable Long accountId) {
    return accountRepository.findById(accountId).map(account -> {
      accountRepository.delete(account);
      responseBody.put("message", "Success");
      return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }).orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + accountId));
  }
}
