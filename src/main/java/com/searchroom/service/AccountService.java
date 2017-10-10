package com.searchroom.service;

import org.springframework.validation.Errors;

public interface AccountService {

    void validate(Object target, String confirmPassword, Errors errors);

}
