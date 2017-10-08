package com.searchroom.controller;

import com.searchroom.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    @RequestMapping(value = "/customerInfo", method = RequestMethod.GET)
    public ModelAndView showInfo() {
        return new ModelAndView("customerInfo", "customer", new Customer());
    }

}
