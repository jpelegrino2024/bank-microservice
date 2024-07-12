package com.juliluis.bankms.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Set;

@ConfigurationProperties(prefix = "contact")
@Getter
@Setter
public class ContactInfoDTO {
    private String email;
    private Set<String> phones;
}
