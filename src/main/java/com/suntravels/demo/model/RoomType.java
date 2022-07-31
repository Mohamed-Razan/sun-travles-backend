package com.suntravels.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rid;
    private String name;
    private int maxAdult;

    @JsonIgnore
    @ManyToOne
    private Hotel hotel;

    @JsonIgnore
    @OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL)
    private List<RoomTypecontract> roomTypecontracts;

    public RoomType() {
    }

    public RoomType(String name, int maxAdult, Hotel hotel) {
        this.name = name;
        this.maxAdult = maxAdult;
        this.hotel = hotel;
    }

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxAdult() {
        return maxAdult;
    }

    public void setMaxAdult(int maxAdult) {
        this.maxAdult = maxAdult;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<RoomTypecontract> getRoomTypecontracts() {
        return roomTypecontracts;
    }

    public void setRoomTypecontracts(List<RoomTypecontract> roomTypecontracts) {
        this.roomTypecontracts = roomTypecontracts;
    }
}
