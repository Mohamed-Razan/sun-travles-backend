package com.suntravels.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cid;

    private Date startDate;
    private Date endDate;
    private boolean isValid;

    @ManyToOne
    private Hotel hotel;

    @JsonIgnore
    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private List<RoomTypecontract> roomTypecontracts;

    public Contract(Date startDate, Date endDate, boolean isValid, Hotel hotel) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.isValid = isValid;
        this.hotel = hotel;
    }

    public Contract() {
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
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
