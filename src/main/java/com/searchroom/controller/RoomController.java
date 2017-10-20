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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.SQLException;

@Controller
@RequestMapping(value = "/rooms")
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

    @Autowired
    private ResourceRepository resourceRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showRoomsPage() {
        return new ModelAndView("rooms", "postList", postNewsRepository.getPostForRoomsPage());
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showPostPage() {
        ModelAndView mav = new ModelAndView("post");
        mav.addObject("newPost", new NewPost());
        mav.addObject("roomTypeList", roomTypeRepository.getRoomTypeList());
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
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

    @RequestMapping(value = "/delete")
    public String editRoom(@RequestParam("post-id") int postId, HttpServletRequest request,
                                 final RedirectAttributes redirectAttributes) {
        int infoId = roomPostRepository.getInfoId(postId);
        int resourceId = resourceRepository.getId(infoId);
        int addressId = roomInfoRepository.getAddressId(infoId);

        resourceRepository.deleteResource(resourceId);
        roomPostRepository.deleteRoomPost(postId);
        roomInfoRepository.deleteRoomInfo(infoId);
        addressRepository.deleteAddress(addressId);

        Account account = (Account) request.getSession().getAttribute("LOGGED_IN_USER");
        redirectAttributes.addFlashAttribute("message", "Deleted post successfully");
        return "redirect:/customer-posts?user=" + account.getUsername();
    }

}
