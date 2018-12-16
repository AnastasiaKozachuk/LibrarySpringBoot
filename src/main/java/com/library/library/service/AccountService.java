package com.library.library.service;

import com.library.library.model.Account;

public interface AccountService {

    Account findByLoginAndPassword(String login, String password);

    void save(Account account);

    Account findByLogin(String login);

}
