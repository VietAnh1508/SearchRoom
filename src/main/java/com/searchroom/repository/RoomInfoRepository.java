package com.searchroom.repository;

import com.searchroom.model.entities.RoomInfo;

public interface RoomInfoRepository {

    int addRoomInfo(RoomInfo roomInfo);
    void deleteRoomInfo(int infoId);
    int getAddressId(int infoId);

}
