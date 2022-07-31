package com.suntravels.demo.serviceImpl;

import com.suntravels.demo.model.Hotel;
import com.suntravels.demo.model.RoomType;
import com.suntravels.demo.repository.RoomTypeRepository;
import com.suntravels.demo.request.RoomTypeRequest;
import com.suntravels.demo.service.IRoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeService implements IRoomTypeService {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private HotelService hotelService;

    public RoomType createRoomType(RoomTypeRequest roomTypeRequest){
        return roomTypeRepository.save(new RoomType(roomTypeRequest.getName(), roomTypeRequest.getMaxAdult(),
                hotelService.getHotelById(roomTypeRequest.getHid())));
    }

    public List<RoomType> getAllRoomTypes(){

        return roomTypeRepository.findAll();
    }

    public RoomType getRoomTypeById(long rid){

        return roomTypeRepository.findById(rid).orElse(null);
    }

    public List<RoomType> getRoomTypeByHotel(long hid){
        Hotel hotel = hotelService.getHotelById(hid);
        return roomTypeRepository.findByHotel(hotel);
    }

    public String updateRoomType(RoomTypeRequest roomTypeRequest){
        RoomType existingRoomType = getRoomTypeById(roomTypeRequest.getRid());

        try{
            existingRoomType.setName(roomTypeRequest.getName());
            existingRoomType.setMaxAdult(roomTypeRequest.getMaxAdult());
            roomTypeRepository.save(existingRoomType);
            return "Success";
        }
        catch (Exception e){
            System.out.println(e);
            return "failed";
        }
    }

    public void deleteRoomType(long rid){
        roomTypeRepository.deleteById(rid);
    }
}
