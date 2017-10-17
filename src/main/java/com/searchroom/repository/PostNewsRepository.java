package com.searchroom.repository;

import com.searchroom.model.PostNews;

import javax.ws.rs.POST;
import java.util.List;

public interface PostNewsRepository {

    List<PostNews> getNewestPost();
    List<PostNews> getPostForRoomsPage();

}
