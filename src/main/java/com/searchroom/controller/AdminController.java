package com.searchroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @RequestMapping(value = "admin")
    public ModelAndView showAdminPage() {
        return new ModelAndView("admin");
    }

}
