package com.searchroom.repository;

import com.searchroom.model.PostNews;

import java.util.List;

public interface PostNewsRepository {

    List<PostNews> getNewestPost();

}
