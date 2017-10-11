package com.searchroom.controller;

import com.searchroom.model.RoomType;
import com.searchroom.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/roomType")
public class RoomTypeController {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String showRoomTypeList(Model model) {
        model.addAttribute("roomType", new RoomType());
        model.addAttribute("roomTypeList", roomTypeRepository.getRoomTypeList());
        return "roomType";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addRoomType(@Valid @ModelAttribute("roomType")RoomType roomType, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("roomType",
                    "roomTypeList", roomTypeRepository.getRoomTypeList());
        }

        if (roomType.getId() == 0) {
            roomTypeRepository.addRoomType(roomType.getDescription());
        } else {
            roomTypeRepository.updateRoomType(roomType);
        }
        return new ModelAndView("redirect:/roomType");
    }

    @RequestMapping("/edit/{id}")
    public String editRoomType(@PathVariable("id") int id, Model model) {
        model.addAttribute("roomType", roomTypeRepository.getRoomTypeById(id));
        model.addAttribute("roomTypeList", roomTypeRepository.getRoomTypeList());
        return "roomType";
    }

    @RequestMapping("/remove/{id}")
    public String removeRoomType(@PathVariable("id") int id) {
        roomTypeRepository.deleteRoomType(id);
        return "redirect:/roomType";
    }

}
