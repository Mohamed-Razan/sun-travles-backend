package com.suntravels.demo.serviceImpl;

import com.suntravels.demo.model.Address;
import com.suntravels.demo.model.Hotel;
import com.suntravels.demo.repository.AddressRepository;
import com.suntravels.demo.repository.HotelRepository;
import com.suntravels.demo.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class HotelService implements IHotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private AddressRepository addressRepository;

    public String createHotel(String name, MultipartFile file, int no, String street, String city, String country){

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a valid image");
            return "failed";
        }

        try {
            Address address = new Address(no, street, city, country);
            Hotel hotel = new Hotel(name, file.getBytes(), address);
            hotelRepository.save(hotel);
            return "success";

        } catch (Exception e) {
            return "failed";
        }
    }

    public List<Hotel> getAllHotels(){

        return hotelRepository.findAll();
    }

    public Hotel getHotelById(long hid){

        return hotelRepository.findById(hid).orElse(null);
    }

    public String updateHotel(long hid, String name, MultipartFile file, int no, String street, String city, String country){

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a valid image");
            return "failed";
        }

        try {
            Hotel existingHotel = getHotelById(hid);
            Address address = new Address(existingHotel.getAddress().getAid(), no, street, city, country);
            existingHotel.setName(name);
            existingHotel.setAddress(address);
            existingHotel.setImage(file.getBytes());
            hotelRepository.save(existingHotel);
            return "success";

        } catch (Exception e) {
            return "failed";
        }
    }

    public void deleteHotel(long hid){

        hotelRepository.deleteById(hid);
    }

}
