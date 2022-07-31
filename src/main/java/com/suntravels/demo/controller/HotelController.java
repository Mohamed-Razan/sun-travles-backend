package com.suntravels.demo.controller;

import com.suntravels.demo.model.Hotel;
import com.suntravels.demo.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class HotelController {

    @Autowired
    private IHotelService service;

    @PostMapping("/create-hotel")
    public String createHotel(@RequestParam String name, @RequestParam MultipartFile file, @RequestParam int no,
                             @RequestParam String street, @RequestParam String city, @RequestParam String country){
        return service.createHotel(name, file, no, street, city, country);
    }

    @GetMapping("/get-all-hotels")
    public List<Hotel> getAllHotels(){

        return service.getAllHotels();
    }

    @GetMapping("/get-hotel-by-id/{hid}")
    public Hotel getHotelById(@PathVariable long hid){

        return service.getHotelById(hid);
    }

    @PutMapping("/update-hotel")
    public String updateHotel(@RequestParam long hid, @RequestParam String name, @RequestParam MultipartFile file, @RequestParam int no,
                              @RequestParam String street, @RequestParam String city, @RequestParam String country){

        return service.updateHotel(hid, name, file, no, street, city, country);
    }

    @DeleteMapping("/delete-hotel/{hid}")
    public void deleteHotel(@PathVariable long hid){
        service.deleteHotel(hid);
    }
}
