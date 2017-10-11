package com.searchroom.repository;

import com.searchroom.model.RoomType;

import java.util.List;

public interface RoomTypeRepository {

    void addRoomType(String description);
    List<RoomType> getRoomTypeList();
    RoomType getRoomTypeById(int id);
    void editRoomType(RoomType roomType);
    void deleteRoomType(int id);

}
