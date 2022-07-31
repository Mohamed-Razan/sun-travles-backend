package com.suntravels.demo.serviceImpl;

import com.suntravels.demo.model.RoomTypeContractKey;
import com.suntravels.demo.model.RoomTypecontract;
import com.suntravels.demo.repository.RoomTypeContractRepository;
import com.suntravels.demo.request.RoomTypeContractRequest;
import com.suntravels.demo.service.IRoomTypeContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoomTypeContractService implements IRoomTypeContractService {

    @Autowired
    private RoomTypeContractRepository roomTypeContractRepository;

    @Autowired
    private ContractService contractService;

    @Autowired
    private RoomTypeService roomTypeService;

    public RoomTypecontract createRoomTypeContract(RoomTypeContractRequest roomTypeContractRequest){
        RoomTypecontract roomTypecontract = new  RoomTypecontract(roomTypeService.getRoomTypeById(roomTypeContractRequest.getRid()),
                contractService.getContractById(roomTypeContractRequest.getCid()), roomTypeContractRequest.getNoOfRooms(),
                roomTypeContractRequest.getPrice());

        return roomTypeContractRepository.save(roomTypecontract);
    }

    public List<RoomTypecontract> getAllRoomTypecontracts(){

        return roomTypeContractRepository.findAll();
    }

    public String updateRoomTypeContract(RoomTypeContractRequest roomTypeContractRequest){

        RoomTypecontract existingRoomTypecontract = roomTypeContractRepository.findById(
                new RoomTypeContractKey(roomTypeContractRequest.getRid(), roomTypeContractRequest.getCid())).orElse(null);

        try{
            existingRoomTypecontract.setId(new RoomTypeContractKey(roomTypeContractRequest.getRid(), roomTypeContractRequest.getCid()));
            existingRoomTypecontract.setNoOfRooms(roomTypeContractRequest.getNoOfRooms());
            existingRoomTypecontract.setPrice(roomTypeContractRequest.getPrice());

            roomTypeContractRepository.save(existingRoomTypecontract);
            return "Success";
        }

        catch (Exception e){
            System.out.println(e);
            return "Failed";
        }
    }

    public void deleteRoomTypeContract(long rid, long cid){
        roomTypeContractRepository.deleteById(new RoomTypeContractKey(rid, cid));
    }

    public List<RoomTypecontract> getAllValidRoomTypecontracts(){

        List<RoomTypecontract> roomTypecontracts = getAllRoomTypecontracts();
        List<RoomTypecontract> validRoomTypecontracts = new ArrayList<>();

        for(int i = 0; i < roomTypecontracts.size(); i++){
            if(roomTypecontracts.get(i).getContract().isValid()){
                validRoomTypecontracts.add(roomTypecontracts.get(i));
            }
        }
        return validRoomTypecontracts;
    }

    public Set<RoomTypecontract> searchRoomTypeContract(Date checkInDate, int noOfNights, int noOfRoom[], int noOfAdults[]){

        Calendar cal = Calendar.getInstance();
        cal.setTime(checkInDate);
        cal.add(Calendar.DATE, noOfNights);
        Date checkOutDate = cal.getTime();
        System.out.println(checkOutDate);
        List<RoomTypecontract> validRoomTypecontracts = getAllValidRoomTypecontracts();

        List<RoomTypecontract> newValidRoomTypecontracts = new ArrayList<>();
        Set<RoomTypecontract> resultRoomTypecontracts = new HashSet<>();
        boolean isValidResult = true;

        for(int i = 0; i < validRoomTypecontracts.size(); i++){

            if((checkInDate.compareTo(validRoomTypecontracts.get(i).getContract().getStartDate()) >= 0) &&
                (checkOutDate.compareTo(validRoomTypecontracts.get(i).getContract().getEndDate()) <= 0)){
                newValidRoomTypecontracts.add(validRoomTypecontracts.get(i));
            }
        }

        for(int i = 0; i < noOfRoom.length; i++){

            for(int j = 0; j < newValidRoomTypecontracts.size(); j++){

                if((noOfRoom[i] <= newValidRoomTypecontracts.get(j).getNoOfRooms()) &&
                    noOfAdults[i] <= newValidRoomTypecontracts.get(j).getRoomType().getMaxAdult()){

                    resultRoomTypecontracts.add(newValidRoomTypecontracts.get(j));
                }
            }
        }

        return resultRoomTypecontracts;
    }
}
