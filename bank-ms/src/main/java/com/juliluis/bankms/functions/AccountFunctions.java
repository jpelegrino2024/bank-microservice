package com.juliluis.bankms.functions;

import com.juliluis.bankms.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class AccountFunctions {

    private static final Logger logger = LoggerFactory.getLogger(AccountFunctions.class);

    @Bean
    public Consumer<String> updateComunication(AccountService accountService) {
        return accountNumber -> {
          logger.info("Updating account");
          boolean result = accountService.updateAccountStatus(accountNumber);
          logger.info("Is account updated? "+ result);
        };
    }
}
