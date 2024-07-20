package com.juliluis.bankms.clients;

import com.juliluis.bankms.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerFallBack implements CustomerClient{
    @Override
    public ResponseEntity<Customer> getCustomer(String correlationId, Long id) {
        return null;
    }
}
