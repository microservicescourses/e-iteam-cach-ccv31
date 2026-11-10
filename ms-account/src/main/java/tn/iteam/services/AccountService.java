package tn.iteam.services;

import tn.iteam.entities.Account;

import java.util.List;

public interface AccountService {
    // on va mettre logique metier
    List<Account> getAllAccounts();
    Account getAccountById (String id);
    void saveAccount(Account account);
}
