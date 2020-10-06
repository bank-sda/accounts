package sda.bank.repository;


import sda.bank.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AccountRepo extends MongoRepository<Account, String> {
    List<Account> getAccountsByOwner(Long ownerId);
}
