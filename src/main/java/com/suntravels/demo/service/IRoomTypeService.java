package com.suntravels.demo.service;

import com.suntravels.demo.model.RoomType;
import com.suntravels.demo.request.RoomTypeRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRoomTypeService {

    RoomType createRoomType(RoomTypeRequest roomTypeRequest);
    List<RoomType> getAllRoomTypes();
    RoomType getRoomTypeById(long rid);
    List<RoomType> getRoomTypeByHotel(long hid);
    String updateRoomType(RoomTypeRequest roomTypeRequest);
    void deleteRoomType(long rid);
}
