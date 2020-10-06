package sda.bank.service;

import lombok.AllArgsConstructor;
import sda.bank.dto.AccountDto;
import sda.bank.mapper.AccountMapper;
import sda.bank.model.Account;
import org.springframework.stereotype.Service;
import sda.bank.repository.AccountRepo;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AccountService {
    AccountRepo accountRepo;
    AccountMapper accountMapper;

    public List<AccountDto> getAccountsByOwnerId(Long ownerId) {
        return accountRepo
                .getAccountsByOwner(ownerId)
                .stream()
                .map(accountMapper::toAccountDto)
                .collect(Collectors.toList());
    }

    public AccountDto addAccount(AccountDto account) {
        account.setId(UUID.randomUUID());
        Account accountSaved = accountRepo.save(accountMapper.toAccount(account));
        return accountMapper.toAccountDto(accountSaved);
    }
}
