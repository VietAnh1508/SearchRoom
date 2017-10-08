package com.searchroom.controller;

import com.searchroom.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/cities")
public class CityController {

    @Autowired
    CityService cityService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCities() {
        return new ModelAndView("cities", "cities", cityService.getCities());
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editCity(@PathVariable("id") int cityId) {
        ModelAndView model;
        if (cityService.getCityById(cityId) == null) {
            model = new ModelAndView("redirect:/cities");
//            return "redirect:/cities";
        } else {
            model = new ModelAndView("editCity");
        }
        return model;
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteCity(@PathVariable("id") int cityId) {
        return "";
    }

}
