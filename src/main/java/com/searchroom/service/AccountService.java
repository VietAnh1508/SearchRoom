package com.searchroom.service;

import com.searchroom.model.Account;
import org.springframework.validation.Errors;

public interface AccountService {

    boolean supports(Class<?> clazz);
    void validate(Object target, String confirmPassword, Errors errors);
    void addAccount(Account account);
    Account getAccount(Account loginAccount);

}
