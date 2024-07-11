package com.juliluis.bankms.controller;

import com.juliluis.bankms.dto.AccountDTO;
import com.juliluis.bankms.model.Account;
import com.juliluis.bankms.model.Contact;
import com.juliluis.bankms.model.Customer;
import com.juliluis.bankms.request.CustomerRequest;
import com.juliluis.bankms.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AccountService accountService;

    @Value("${customer.url}")
    private String customerUrl;

    @PostMapping
    public ResponseEntity<Account> create(@RequestBody CustomerRequest request) {
        System.out.println(customerUrl);
        String uri = customerUrl + request.getCustomerId();
        HttpHeaders headers = new HttpHeaders();
        headers.add("invocationFrom", "RestTemplate");
        ResponseEntity<Customer> response = restTemplate.getForEntity(uri, Customer.class);
        Customer customer = response.getBody();
        if (response.getStatusCode().value() != 200) {
            throw new RuntimeException("Sorry we could not find customer service");
        }
        Account accountSaved = accountService.create(customer);
        return ResponseEntity.status(201).body(accountSaved);
    }

    @GetMapping(path = "{email}")
    public ResponseEntity<AccountDTO> getAccountNumber(@PathVariable(name = "email") String emailAddress) {
        AccountDTO accountDTO = accountService.getAccountNumber(emailAddress);

        return ResponseEntity.ok(accountDTO);
    }
}
