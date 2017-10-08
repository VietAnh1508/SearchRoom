package com.searchroom.controller;

import com.searchroom.model.Account;
import com.searchroom.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@SessionAttributes("loginedAccount")
public class AccountController {

    @Autowired
    private AccountService accountService;

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

        accountService.addAccount(account);
        return new ModelAndView("redirect:/login",
                "notification", "Create account successfully");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLoginForm() {
        return new ModelAndView("login", "account", new Account());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginSubmit(@Valid @ModelAttribute("account")Account account, BindingResult result) {
        ModelAndView model = null;
        if (result.hasErrors()) {
            return new ModelAndView("login");
        }

        Account loginedAccount = accountService.getAccount(account);
        if (loginedAccount != null) {
            model = new ModelAndView("redirect:/customerInfo");
            model.addObject("loginedAccount", loginedAccount);
        } else {
            model = new ModelAndView("login");
            model.addObject("message", "Username or Password is invalid");
        }

        return model;
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout(SessionStatus status) {
        status.setComplete();
        return new ModelAndView("redirect:/index");
    }

}
