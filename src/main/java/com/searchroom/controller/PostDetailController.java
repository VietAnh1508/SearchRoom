package com.searchroom.controller;

import com.searchroom.model.join.PostDetail;
import com.searchroom.repository.PostDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostDetailController {

    @Autowired
    private PostDetailRepository postDetailRepository;

    @RequestMapping(value = "/detail")
    public ModelAndView showDetailPage(@RequestParam("post-id") int postId) {
        return new ModelAndView("detail", "postDetail", postDetailRepository.getPostDetail(postId));
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/saveRoom/{postId}")
    public String saveRoomPost(@PathVariable(value = "postId")int postId, HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<PostDetail> postDetails = (List<PostDetail>) session.getAttribute("savePosts");
        if (postDetails == null) {
            postDetails = new ArrayList<>();
        }
        postDetails.add(postDetailRepository.getPostToSave(postId));
        session.setAttribute("savedPosts", postDetails);
        return "redirect:/detail/" + postId;
    }

}
