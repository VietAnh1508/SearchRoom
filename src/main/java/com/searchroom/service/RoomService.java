package com.searchroom.service;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public interface RoomService {

    void uploadFile(HttpServletRequest request, int roomInfoId) throws SQLException;

}
