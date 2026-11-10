package tn.iteam.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.iteam.entities.Account;

import tn.iteam.repositories.AccountRepository;

import java.util.List;
import java.util.Optional;


@Service

public class AccountServiceImpl implements AccountService {
    // appels couche repo

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById (String id) {
     return accountRepository.findById(id).orElse(null);
    }

    @Override
    public  void saveAccount(Account account) {
        accountRepository.save(account);
    }
}
