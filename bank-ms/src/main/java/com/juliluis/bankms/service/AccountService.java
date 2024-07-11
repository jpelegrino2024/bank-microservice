package com.juliluis.bankms.service;

import com.juliluis.bankms.dto.AccountDTO;
import com.juliluis.bankms.dto.CustomerDTO;
import com.juliluis.bankms.model.Account;
import com.juliluis.bankms.model.Customer;
import com.juliluis.bankms.repository.AccountRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account create(Customer customer) {
        Account account = new Account();
        CustomerDTO customerDTO = new CustomerDTO(customer);
        account.setName(customerDTO.fullName());
        account.setAccountNumber(RandomStringUtils.randomAlphabetic(17));
        account.setEmailAddress(customer.getEmail());

        return accountRepository.save(account);
    }

    public AccountDTO getAccountNumber(String emailAddress) {
        AccountDTO dto = new AccountDTO();
        Account account = accountRepository.findAccountByEmailAddress(emailAddress);
        dto.setAccountNumber(account.getAccountNumber());
        return dto;
    }
}
