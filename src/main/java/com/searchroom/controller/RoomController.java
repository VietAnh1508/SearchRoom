package com.searchroom.controller;

import com.searchroom.model.entities.*;
import com.searchroom.model.join.NewPost;
import com.searchroom.model.join.PostNews;
import com.searchroom.repository.*;
import com.searchroom.service.AddressService;
import com.searchroom.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.SQLException;

@Controller
public class RoomController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private RoomInfoRepository roomInfoRepository;

    @Autowired
    private RoomPostRepository roomPostRepository;

    @Autowired
    private RoomService roomService;

    @Autowired
    private PostNewsRepository postNewsRepository;

    @RequestMapping(value = "/rooms")
    public ModelAndView showRoomsPage() {
        return new ModelAndView("rooms", "postList", postNewsRepository.getPostForRoomsPage());
    }

    @RequestMapping(value = "/addRoom", method = RequestMethod.GET)
    public ModelAndView showPostPage() {
        ModelAndView mav = new ModelAndView("post");
        mav.addObject("newPost", new NewPost());
        mav.addObject("roomTypeList", roomTypeRepository.getRoomTypeList());
        return mav;
    }

    @RequestMapping(value = "/addRoom", method = RequestMethod.POST)
    public ModelAndView addNewRoom(@ModelAttribute("newPost")NewPost newPost, HttpServletRequest request)
            throws SQLException {
        ModelAndView mav = new ModelAndView("post");
        mav.addObject("roomTypeList", roomTypeRepository.getRoomTypeList());

        Account loggedInUser = (Account) request.getSession().getAttribute("LOGGED_IN_USER");
        Customer customerInfo = customerRepository.getCustomerByUsername(loggedInUser.getUsername());
        if (customerInfo.getFullName() == null) {
            mav.addObject("message", "Please complete your information before post new room");
            return mav;
        }

        if ("".equals(newPost.getTitle()) || "".equals(newPost.getAddress()) || "".equals(newPost.getDescription())) {
            mav.addObject("message", "Please fill all the fields");
            return mav;
        }

        Address addressObject;
        try {
            addressObject = addressService.getLatLngByAddress(newPost.getAddress());
        } catch (Exception e) {
            e.printStackTrace();
            mav.addObject("message", "Unknown error, please try again");
            return mav;
        }

        int addressId = addressRepository.addAddress(addressObject);

        RoomInfo roomInfo = new RoomInfo(newPost.getTitle(), newPost.getArea(), newPost.getPrice(),
                newPost.getDescription(), addressId, newPost.getTypeId());
        int roomInfoId = roomInfoRepository.addRoomInfo(roomInfo);

        Customer customer = customerRepository.getCustomerByUsername(loggedInUser.getUsername());
        RoomPost roomPost = new RoomPost(customer.getId(), roomInfoId);
        roomPostRepository.addRoomPost(roomPost);

        roomService.uploadFile(request, roomInfoId);

        mav.addObject("message", "Add new room succeed");
        return mav;
    }

}
