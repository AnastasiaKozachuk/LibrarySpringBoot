package com.library.library.service;

import com.library.library.model.Account;
import com.library.library.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findByLoginAndPassword(String login, String password) {
        return accountRepository.findByLoginAndPassword(login, password);
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Account findByLogin(String login) {
        return accountRepository.findByLogin(login);
    }
}
