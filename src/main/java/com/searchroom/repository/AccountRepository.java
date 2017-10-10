package com.searchroom.repository;

import com.searchroom.model.Account;

public interface AccountRepository {

    void addAccount(Account account);
    Account getAccount(Account account);
    Account getAccountByUsername(String username);

}
