package com.searchroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = { "/", "/index" })
    public String home(Model model) {
        model.addAttribute("greeting", "Welcome to my website");
        return "index";
    }

}
