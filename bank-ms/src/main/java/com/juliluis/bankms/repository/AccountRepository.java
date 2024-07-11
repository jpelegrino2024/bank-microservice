package com.juliluis.bankms.repository;

import com.juliluis.bankms.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountByEmailAddress(String email);
}
