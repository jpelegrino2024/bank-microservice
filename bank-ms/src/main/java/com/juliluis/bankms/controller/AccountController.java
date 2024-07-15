package com.juliluis.bankms.controller;

import com.juliluis.bankms.clients.CustomerClient;
import com.juliluis.bankms.dto.AccountDTO;
import com.juliluis.bankms.dto.ContactInfoDTO;
import com.juliluis.bankms.dto.CustomerInfoDTO;
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

    @Autowired
    private CustomerInfoDTO customerInfoDTO;

    @Autowired
    private ContactInfoDTO contactInfoDTO;

    @Autowired
    private CustomerClient customerClient;

    @PostMapping
    public ResponseEntity<Account> create(@RequestBody CustomerRequest request) {
//        System.out.println(customerUrl);
//        String uri = customerUrl + request.getCustomerId();
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("invocationFrom", "RestTemplate");
        ResponseEntity<Customer> response = customerClient.getCustomer(request.getCustomerId());
        Customer customer = response.getBody();
        if (response.getStatusCode().value() != 200) {
            throw new RuntimeException("Sorry we could not find customer service");
        }
        Account accountSaved = accountService.create(customer);
        return ResponseEntity.status(201).body(accountSaved);
    }

    @GetMapping(path = "{email}")
    public ResponseEntity<AccountDTO> getAccountNumber(@PathVariable(name = "email") String emailAddress) {
        System.out.println("Configuration properties:: "+ customerInfoDTO.getUrl());
        AccountDTO accountDTO = accountService.getAccountNumber(emailAddress);

        return ResponseEntity.ok(accountDTO);
    }

    @GetMapping(path = "contact-info")
    public ResponseEntity<ContactInfoDTO> contactInfo() {
        return ResponseEntity.ok().body(contactInfoDTO);
    }
}
