package com.searchroom.repository;

import com.searchroom.model.join.PostNews;

import java.util.List;

public interface PostNewsRepository {

    List<PostNews> getNewestPost();
    List<PostNews> getPostForRoomsPage();
    List<PostNews> getCustomerPosts(int customerId);

}
