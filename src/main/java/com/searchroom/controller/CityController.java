package com.searchroom.controller;

import com.searchroom.model.City;
import com.searchroom.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/cities")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getCities(Model model) {
        model.addAttribute("city", new City());
        model.addAttribute("cities", cityRepository.getCities());
        return "cities";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editCity(@PathVariable("id") int cityId) {
        ModelAndView model;
        if (cityRepository.getCityById(cityId) == null) {
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
