package com.searchroom.controller;

import com.searchroom.model.entities.Account;
import com.searchroom.repository.AccountRepository;
import com.searchroom.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class AdminController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(value = "/admin-login")
    public ModelAndView showLoginPage() {
        return new ModelAndView("adminLogin", "account", new Account());
    }

    @RequestMapping(value = "/admin-login", method = RequestMethod.POST)
    public ModelAndView loginSubmit(@Valid @ModelAttribute("account") Account account,
                                    BindingResult result, HttpServletRequest request, HttpServletResponse response) {
        if (result.hasErrors()) {
            return new ModelAndView("adminLogin");
        }

        ModelAndView model;
        String hashedPassword = accountService.md5Hash(account.getPassword());
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
                model = new ModelAndView("redirect:/login");
            } else {
                model = new ModelAndView("redirect:/admin");
            }
        } else {
            model = new ModelAndView("login",
                    "message", "Username or Password is incorrect");
        }

        return model;
    }

    @RequestMapping(value = "/admin")
    public ModelAndView showAdminPage() {
        return new ModelAndView("adminMain");
    }

}
