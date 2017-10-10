package com.searchroom.controller;

import com.searchroom.model.RoomType;
import com.searchroom.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RoomTypeController {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @RequestMapping(value = "/roomType", method = RequestMethod.GET)
    public ModelAndView showRoomTypeList() {
        return new ModelAndView("roomType", "roomTypeList", roomTypeRepository.getRoomTypeList());
    }

    @RequestMapping(value = "/add-room-type", method = RequestMethod.POST)
    public ModelAndView addRoomType(@Valid @ModelAttribute("description") RoomType roomType, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("roomType");
        }

        roomTypeRepository.addRoomType(roomType.getDescription());
        return new ModelAndView("redirect:/roomType");
    }

}
