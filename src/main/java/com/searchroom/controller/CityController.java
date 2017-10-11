package com.searchroom.controller;

import com.searchroom.model.City;
import com.searchroom.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String showCityList(Model model) {
        model.addAttribute("city", new City());
        model.addAttribute("cityList", cityRepository.getCityList());
        return "city";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addCity(@Valid @ModelAttribute("city")City city, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("city",
                    "cityList", cityRepository.getCityList());
        }

        if (city.getId() == 0) {
            cityRepository.addCity(city.getName());
        } else {
            cityRepository.updateCity(city);
        }
        return new ModelAndView("redirect:/city");
    }

    @RequestMapping("/edit/{id}")
    public String editCity(@PathVariable("id") int id, Model model) {
        model.addAttribute("city", cityRepository.getCityById(id));
        model.addAttribute("cityList", cityRepository.getCityList());
        return "city";
    }

    @RequestMapping("/delete/{id}")
    public String removeCity(@PathVariable("id") int id) {
        cityRepository.deleteCity(id);
        return "redirect:/city";
    }

}
