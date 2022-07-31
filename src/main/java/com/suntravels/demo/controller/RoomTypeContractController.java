package com.suntravels.demo.controller;

import com.suntravels.demo.model.RoomTypecontract;
import com.suntravels.demo.request.RoomTypeContractRequest;
import com.suntravels.demo.service.IRoomTypeContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
public class RoomTypeContractController {

    @Autowired
    private IRoomTypeContractService service;

    @PostMapping("/create-room-type-contract")
    public RoomTypecontract createRoomTypeContract(@RequestBody RoomTypeContractRequest roomTypeContractRequest){
        return service.createRoomTypeContract(roomTypeContractRequest);
    }

    @GetMapping("/get-all-room-type-contracts")
    public List<RoomTypecontract> getAllRoomTypecontracts(){
        return service.getAllRoomTypecontracts();
    }

    @PutMapping("/update-room-type-contract")
    public String updateRoomTypeContract(@RequestBody RoomTypeContractRequest roomTypeContractRequest){
        return service.updateRoomTypeContract(roomTypeContractRequest);
    }

    @DeleteMapping("/delete-room-type-contract/{rid}/{cid}")
    public void deleteRoomTypeContract(@PathVariable long rid, @PathVariable long cid){
        service.deleteRoomTypeContract(rid, cid);
    }

    @GetMapping("/search-contract")
    public Set<RoomTypecontract> SearchRoomTypeContract(@RequestParam Date checkInDate, @RequestParam int noOfNights,
                                                       @RequestParam int noOfRoom[], @RequestParam int noOfAdults[]){
        return service.searchRoomTypeContract(checkInDate, noOfNights, noOfRoom, noOfAdults);
    }
}
