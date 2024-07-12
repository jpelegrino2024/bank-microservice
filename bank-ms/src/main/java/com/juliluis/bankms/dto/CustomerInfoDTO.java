package com.juliluis.bankms.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "customer")
@Getter
@Setter
public class CustomerInfoDTO {
    private String url;
}