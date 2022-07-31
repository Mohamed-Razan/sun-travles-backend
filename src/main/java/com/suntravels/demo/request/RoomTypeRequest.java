package com.suntravels.demo.request;

public class RoomTypeRequest {

    private long rid;
    private long hid;
    private String name;
    private int maxAdult;

    public RoomTypeRequest(long hid, String name, int maxAdult) {
        this.hid = hid;
        this.name = name;
        this.maxAdult = maxAdult;
    }

    public RoomTypeRequest(long rid, long hid, String name, int maxAdult) {
        this.rid = rid;
        this.hid = hid;
        this.name = name;
        this.maxAdult = maxAdult;
    }

    public RoomTypeRequest() {
    }

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public long getHid() {
        return hid;
    }

    public void setHid(long hid) {
        this.hid = hid;
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
}
