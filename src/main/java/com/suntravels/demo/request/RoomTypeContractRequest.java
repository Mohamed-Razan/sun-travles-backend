package com.suntravels.demo.request;

public class RoomTypeContractRequest {

    private long rid;
    private long cid;
    private int noOfRooms;
    private double price;

    public RoomTypeContractRequest(long rid, long cid, int noOfRooms, double price) {
        this.rid = rid;
        this.cid = cid;
        this.noOfRooms = noOfRooms;
        this.price = price;
    }

    public RoomTypeContractRequest() {
    }

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }
}
