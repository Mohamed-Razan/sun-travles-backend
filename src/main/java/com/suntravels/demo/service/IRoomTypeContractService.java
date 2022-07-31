package com.suntravels.demo.service;

import com.suntravels.demo.model.RoomTypecontract;
import com.suntravels.demo.request.RoomTypeContractRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public interface IRoomTypeContractService {

    RoomTypecontract createRoomTypeContract(RoomTypeContractRequest roomTypeContractRequest);
    List<RoomTypecontract> getAllRoomTypecontracts();
    String updateRoomTypeContract(RoomTypeContractRequest roomTypeContractRequest);
    void deleteRoomTypeContract(long rid, long cid);
    Set<RoomTypecontract> searchRoomTypeContract(Date checkInDate, int noOfNights, int noOfRoom[], int noOfAdults[]);
}
