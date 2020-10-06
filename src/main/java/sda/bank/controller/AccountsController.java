package sda.bank.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import sda.bank.dto.AccountDto;
import sda.bank.service.AccountService;

import java.util.List;

@RefreshScope
@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping(value = "api/accounts")
public class AccountsController {
    @Value("${application.allowed-get-accounts}")
    private boolean allowedAccounts;
    private final AccountService accountService;



    @GetMapping("/{ownerId}")
    public List<AccountDto> getAccounts(@PathVariable Long ownerId) {

        if (allowedAccounts) {
            log.info("get by owner");
            List<AccountDto> accountsByOwnerId = accountService.getAccountsByOwnerId(ownerId);
            System.out.println(accountsByOwnerId);
            return accountsByOwnerId;
        } else {
            throw new RuntimeException("Accounts not available");
        }

    }

    @PostMapping("")
    public AccountDto getAccounts(@RequestBody AccountDto account) {
        return accountService.addAccount(account);
    }
}
