package com.searchroom.repository;

import com.searchroom.model.Account;

public interface AccountRepository {

    Account getAccount(Account account);
    void addAccount(Account account);

}
