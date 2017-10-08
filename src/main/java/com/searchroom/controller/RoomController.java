package com.searchroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoomController {

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public ModelAndView postRoom() {
        return new ModelAndView("post");
    }

}
