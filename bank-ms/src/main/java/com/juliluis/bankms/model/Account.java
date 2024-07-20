package com.juliluis.bankms.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.print.attribute.standard.MediaSize;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(unique = true)
    private String accountNumber;
    @Column(unique = true)
    private String emailAddress;
    @Column(name = "updated_account")
    private Boolean updatedAccount;
}
