package com.suntravels.demo.service;

import com.suntravels.demo.model.Hotel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface IHotelService {

    String createHotel(String name, MultipartFile file, int no, String street, String city, String country);
    List<Hotel> getAllHotels();
    public Hotel getHotelById(long hid);
    public String updateHotel(long hid, String name, MultipartFile file, int no, String street, String city, String country);
    void deleteHotel(long hid);
}
