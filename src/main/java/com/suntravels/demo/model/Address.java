package com.suntravels.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long aid;
    private int no;
    private String street;
    private String city;
    private String country;

    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private Hotel hotel;

    public Address() {
    }

    public Address(long aid, int no, String street, String city, String country) {
        this.aid = aid;
        this.no = no;
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public Address(int no, String street, String city, String country) {
        this.no = no;
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public long getAid() {
        return aid;
    }

    public void setAid(long aid) {
        this.aid = aid;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
