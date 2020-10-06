package sda.bank.mapper;

import org.springframework.stereotype.Component;
import sda.bank.dto.AccountDto;
import sda.bank.model.Account;

@Component
public class AccountMapper {

    public AccountDto toAccountDto(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .name(account.getName())
                .owner(account.getOwner())
                .type(account.getType())
                .currency(account.getCurrency())
                .value(account.getValue())
                .build();
    }

    public Account toAccount(AccountDto accountDto) {
        return Account.builder()
                .id(accountDto.getId())
                .name(accountDto.getName())
                .owner(accountDto.getOwner())
                .type(accountDto.getType())
                .currency(accountDto.getCurrency())
                .value(accountDto.getValue())
                .build();
    }
}
