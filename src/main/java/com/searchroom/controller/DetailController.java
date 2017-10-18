package com.searchroom.controller;

import com.searchroom.repository.PostDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DetailController {

    @Autowired
    private PostDetailRepository postDetailRepository;

    @RequestMapping(value = "/detail/{postId}")
    public ModelAndView showDetailPage(@PathVariable("postId")int postId) {
        return new ModelAndView("detail", "postDetail", postDetailRepository.getPostDetail(postId));
    }

}
