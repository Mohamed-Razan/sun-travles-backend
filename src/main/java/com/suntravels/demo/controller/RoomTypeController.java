package com.suntravels.demo.controller;

import com.suntravels.demo.model.RoomType;
import com.suntravels.demo.request.RoomTypeRequest;
import com.suntravels.demo.service.IRoomTypeService;
import com.suntravels.demo.serviceImpl.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomTypeController {

    @Autowired
    private IRoomTypeService service;

    @PostMapping("/create-room-type")
    public RoomType createRoomType(@RequestBody RoomTypeRequest roomTypeRequest){
        return service.createRoomType(roomTypeRequest);
    }

    @GetMapping("/get-all-room-types")
    List<RoomType> getAllRoomTypes(){

        return service.getAllRoomTypes();
    }

    @GetMapping("/get-room-type-by-id/{rid}")
    public RoomType getRoomTypeById(@PathVariable long rid){

        return service.getRoomTypeById(rid);
    }

    @GetMapping("/get-room-type-by-hotel/{hid}")
    public List<RoomType> getRoomTypeByHotel(@PathVariable long hid){

        return service.getRoomTypeByHotel(hid);
    }

    @PutMapping("/update-room-type")
    public String updateRoomType(@RequestBody RoomTypeRequest roomTypeRequest){
        return service.updateRoomType(roomTypeRequest);
    }

    @DeleteMapping("/delete-room-type/{rid}")
    public void deleteRoomType(@PathVariable long rid){
        service.deleteRoomType(rid);
    }
}
