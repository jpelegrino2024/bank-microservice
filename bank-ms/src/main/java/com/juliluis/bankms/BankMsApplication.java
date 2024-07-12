package com.juliluis.bankms;

import com.juliluis.bankms.dto.ContactInfoDTO;
import com.juliluis.bankms.dto.CustomerInfoDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties(value = {CustomerInfoDTO.class, ContactInfoDTO.class})
public class BankMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankMsApplication.class, args);
    }

}
