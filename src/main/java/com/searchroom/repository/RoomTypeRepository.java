package com.searchroom.repository;

import com.searchroom.model.RoomType;

import java.util.List;

public interface RoomTypeRepository {

    void addRoomType(String description);
    void updateRoomType(RoomType roomType);
    void deleteRoomType(int id);
    RoomType getRoomTypeById(int id);
    List<RoomType> getRoomTypeList();

}
