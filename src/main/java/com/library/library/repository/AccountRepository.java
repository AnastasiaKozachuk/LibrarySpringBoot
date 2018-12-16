package com.library.library.repository;

import com.library.library.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {

    Account findByLoginAndPassword(String login, String password);
    Account findByLogin(String login);

}
