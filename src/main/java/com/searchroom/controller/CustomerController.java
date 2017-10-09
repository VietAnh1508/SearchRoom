package com.searchroom.controller;

import com.searchroom.model.Account;
import com.searchroom.model.Customer;
import com.searchroom.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customerInfo", method = RequestMethod.GET)
    public ModelAndView showInfo(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("customerInfo");

        Account loginedUser = (Account) request.getSession().getAttribute("LOGINED_USER");
        Customer customer = customerService.getCustomerByUsername(loginedUser.getUsername());
        if (customer == null) {
            customer = new Customer();
            customer.setUsername(loginedUser.getUsername());
            mav.addObject("notification", "Please complete your information to post news");
        }

        mav.addObject("customer", customer);
        return mav;
    }

    @RequestMapping(value = "customerInfo", method = RequestMethod.POST)
    public ModelAndView addCustomer(@Valid @ModelAttribute("customer")Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(customer.getUsername());
            return new ModelAndView("customerInfo", "customer", customer);
        }
        customerService.addCustomer(customer);
        return new ModelAndView("customerInfo", "notification", "Update info successfully");
    }

}
