package com.dzmitrykamarou.diamond.repository;

import com.dzmitrykamarou.diamond.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
