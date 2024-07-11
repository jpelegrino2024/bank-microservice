package com.juliluis.bankms.dto;

import com.juliluis.bankms.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Customer customer;

    public String fullName() {
        return customer.getFirstName() + " " + customer.getLastName();
    }
}
