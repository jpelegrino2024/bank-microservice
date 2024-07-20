package com.juliluis.bankms.service;

import com.juliluis.bankms.clients.CustomerClient;
import com.juliluis.bankms.dto.AccountDTO;
import com.juliluis.bankms.dto.CustomerDTO;
import com.juliluis.bankms.model.Account;
import com.juliluis.bankms.model.Customer;
import com.juliluis.bankms.repository.AccountRepository;
import com.juliluis.bankms.request.CustomerRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerClient customerClient;

    public Account create(CustomerRequest request, String correlationId) {


        ResponseEntity<Customer> response = customerClient.getCustomer(correlationId,request.getCustomerId());

        if (Objects.nonNull(response)) {
            Account account = new Account();
            CustomerDTO customerDTO = new CustomerDTO(response.getBody());
            account.setName(customerDTO.fullName());
            account.setAccountNumber(RandomStringUtils.randomAlphabetic(17));
            account.setEmailAddress(response.getBody().getEmail());

            return accountRepository.save(account);
        }

        return null;

    }

    public AccountDTO getAccountNumber(String emailAddress) {
        AccountDTO dto = new AccountDTO();
        Account account = accountRepository.findAccountByEmailAddress(emailAddress);
        dto.setAccountNumber(account.getAccountNumber());
        return dto;
    }

    public boolean updateAccountStatus(String accountNumber) {
        boolean updated = false;
        if(Objects.nonNull(accountNumber)) {
            Account account = accountRepository.findByAccountNumber(accountNumber).orElseThrow();

            account.setUpdatedAccount(true);
            accountRepository.save(account);
            updated = true;
        }

        return updated;
    }
}
