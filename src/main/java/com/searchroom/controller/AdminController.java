package com.searchroom.controller;

import com.searchroom.model.entities.Account;
import com.searchroom.model.entities.RoomType;
import com.searchroom.repository.AccountRepository;
import com.searchroom.repository.RoomTypeRepository;
import com.searchroom.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @RequestMapping(value = "/login")
    public ModelAndView showLoginPage() {
        return new ModelAndView("adminLogin", "account", new Account());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginSubmit(@Valid @ModelAttribute("account") Account account,
                                    BindingResult result, HttpServletRequest request, HttpServletResponse response) {
        if (result.hasErrors()) {
            return new ModelAndView("adminLogin");
        }

        ModelAndView model;
        String hashedPassword = accountService.md5Hash(account.getPassword());
        account.setPassword(hashedPassword);
        Account loggedInAccount = accountRepository.getAccount(account);

        if (loggedInAccount != null) {
            request.getSession().setAttribute("LOGGED_IN_USER", loggedInAccount);

            boolean isRemember = "Y".equals(request.getParameter("remember-me"));
            if (isRemember) {
                Cookie cookie = new Cookie("LOGGED_IN_USER", loggedInAccount.getUsername());
                cookie.setMaxAge(24*60*60); // 1 day
                response.addCookie(cookie);
            }

            if (loggedInAccount.getRole().equals("CUSTOMER")) {
                model = new ModelAndView("redirect:/");
            } else {
                model = new ModelAndView("redirect:/admin/room-type");
            }
        } else {
            model = new ModelAndView("login",
                    "message", "Username or Password is incorrect");
        }

        return model;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAdminPage() {
        return new ModelAndView("/admin/room-type");
    }

    // Controllers for add room types
    @RequestMapping(value = "/room-type", method = RequestMethod.GET)
    public String showRoomTypeList(Model model) {
        model.addAttribute("roomType", new RoomType());
        model.addAttribute("roomTypeList", roomTypeRepository.getRoomTypeList());
        return "roomTypes";
    }

    @RequestMapping(value = "/room-type/update", method = RequestMethod.POST)
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
        return new ModelAndView("redirect:/admin/room-type");
    }

    @RequestMapping("/room-type/edit")
    public String editRoomType(@RequestParam("id") int id, Model model) {
        model.addAttribute("roomType", roomTypeRepository.getRoomTypeById(id));
        model.addAttribute("roomTypeList", roomTypeRepository.getRoomTypeList());
        return "roomTypes";
    }

    @RequestMapping("/room-type/delete")
    public String removeRoomType(@RequestParam("id") int id) {
        roomTypeRepository.deleteRoomType(id);
        return "redirect:/admin/room-type";
    }

}
