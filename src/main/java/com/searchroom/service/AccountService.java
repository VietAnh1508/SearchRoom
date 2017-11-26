package com.searchroom.service;

import org.springframework.validation.Errors;

import javax.servlet.http.HttpServletRequest;

public interface AccountService {

    void validate(Object target, Errors errors);
    String md5Hash(String input);
    boolean changePassword(HttpServletRequest request);

}
