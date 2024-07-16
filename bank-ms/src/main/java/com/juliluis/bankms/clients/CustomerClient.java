package com.juliluis.bankms.clients;

import com.juliluis.bankms.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient("customer")
public interface CustomerClient {

    @GetMapping(path = "/api/customers/{id}")
    ResponseEntity<Customer> getCustomer(
            @RequestHeader("wiremoney-correlation-id") String correlationId,
            @PathVariable(name = "id") Long id);
}
