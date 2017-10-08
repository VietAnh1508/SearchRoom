package com.searchroom.service.impl;

import com.searchroom.model.Account;
import com.searchroom.repository.AccountRepository;
import com.searchroom.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    public boolean supports(Class<?> clazz) {
        return Account.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, String confirmPassword, Errors errors) {
        Account account = (Account) target;

        if (!(account.getPassword()).equals(confirmPassword)) {
            errors.rejectValue("password",
                    "matchingPassword.account.password",
                    "Password and Confirm password not match");
        }
    }

    public void addAccount(Account account) {
        accountRepository.addAccount(account);
    }

    public Account getAccount(Account loginAccount) {
        return accountRepository.getAccount(loginAccount);
    }

}
