package com.searchroom.controller;

import com.searchroom.model.Account;
import com.searchroom.repository.AccountRepository;
import com.searchroom.service.AccountService;
import com.searchroom.utils.MD5Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegisterForm() {
        return new ModelAndView("register", "account", new Account());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerSubmit(@Valid @ModelAttribute("account")Account account,
                                       @RequestParam("confirm-password") String confirmPass, BindingResult result) {
        accountService.validate(account, confirmPass, result); // fix this shit
        if (result.hasErrors()) {
            return new ModelAndView("register");
        }

        String hashedPassword = MD5Library.md5(account.getPassword());
        account.setPassword(hashedPassword);
        accountRepository.addAccount(account);
        return new ModelAndView("register",
                "notification", "Create account successfully");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLoginForm() {
        return new ModelAndView("login", "account", new Account());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginSubmit(@Valid @ModelAttribute("account")Account account,
                                    BindingResult result, HttpServletRequest request, HttpServletResponse response) {
        if (result.hasErrors()) {
            return new ModelAndView("login");
        }

        ModelAndView model;
        String hashedPassword = MD5Library.md5(account.getPassword());
        account.setPassword(hashedPassword);
        Account loggedInAccount = accountRepository.getAccount(account);

        if (loggedInAccount != null) {
            request.getSession().setAttribute("LOGGED_IN_USER", loggedInAccount);

            boolean isRemember = "Y".equals(request.getParameter("remember-me"));
            if (isRemember) {
                Cookie cookie = new Cookie("LOGGED_IN_USER", loggedInAccount.getUsername());
                cookie.setMaxAge(24*60*60); // 1 day
                response.addCookie(cookie);
            }

            if (loggedInAccount.getRole().equals("CUSTOMER")) {
                model = new ModelAndView("redirect:/customerInfo");
            } else {
                model = new ModelAndView("redirect:/admin");
            }
        } else {
            model = new ModelAndView("login",
                    "message", "Username or Password is incorrect");
        }

        return model;
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        Cookie cookie = new Cookie("LOGGED_IN_USER", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return new ModelAndView("redirect:/index");
    }

}
