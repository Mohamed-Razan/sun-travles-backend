package com.suntravels.demo.model;

import javax.persistence.*;

@Entity
public class RoomTypecontract {

    @EmbeddedId
    private RoomTypeContractKey id;

    @ManyToOne
    @MapsId("rid")
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;


    @ManyToOne
    @MapsId("cid")
    @JoinColumn(name = "contract_id")
    private  Contract contract;

    private int NoOfRooms;
    private double price;

    public RoomTypecontract(RoomType roomType, Contract contract, int noOfRooms, double price) {
        this.id = new RoomTypeContractKey(roomType.getRid(), contract.getCid());
        this.roomType = roomType;
        this.contract = contract;
        NoOfRooms = noOfRooms;
        this.price = price;
    }

    public RoomTypecontract() {
    }

    public RoomTypeContractKey getId() {
        return id;
    }

    public void setId(RoomTypeContractKey id) {
        this.id = id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public int getNoOfRooms() {
        return NoOfRooms;
    }

    public void setNoOfRooms(int noOfRooms) {
        NoOfRooms = noOfRooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
