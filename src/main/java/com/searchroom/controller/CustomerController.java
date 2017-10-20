package com.searchroom.controller;

import com.searchroom.model.entities.Account;
import com.searchroom.model.entities.Customer;
import com.searchroom.repository.CustomerRepository;
import com.searchroom.repository.PostNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PostNewsRepository postNewsRepository;

    @RequestMapping(value = "/customerInfo", method = RequestMethod.GET)
    public ModelAndView showInfo(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("customerInfo");

        Account loginedUser = (Account) request.getSession().getAttribute("LOGGED_IN_USER");
        Customer customer = customerRepository.getCustomerByUsername(loginedUser.getUsername());
        if (customer == null) {
            customer = new Customer();
            customer.setUsername(loginedUser.getUsername());
            mav.addObject("notification", "Please complete your information to post news");
        }

        mav.addObject("customer", customer);
        return mav;
    }

    @RequestMapping(value = "/customerInfo", method = RequestMethod.POST)
    public ModelAndView addCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
        ModelAndView mav = new ModelAndView("customerInfo");
        if (result.hasErrors()) {
            mav.addObject("customer", customer);
            return mav;
        }

        Customer alreadyExistCustomer = customerRepository.getCustomerByUsername(customer.getUsername());
        if (alreadyExistCustomer == null) {
            customerRepository.addCustomer(customer);
        } else {
            customerRepository.updateCustomer(customer);
        }
        mav.addObject("notification", "Update info successfully");
        return mav;
    }

    @RequestMapping(value = "/customerPost/{username}")
    public ModelAndView getCustomerPosts(@PathVariable("username") String username) {
        int customerId = customerRepository.getCustomerByUsername(username).getId();
        return new ModelAndView("customerPost",
                "postList", postNewsRepository.getCustomerPosts(customerId));
    }

}
