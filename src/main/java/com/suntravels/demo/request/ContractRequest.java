package com.suntravels.demo.request;

import java.util.Date;

public class ContractRequest {

    private long cid;
    private long hid;
    private Date startDate;
    private Date endDate;

    public ContractRequest(long cid, long hid, Date startDate, Date endDate) {
        this.cid = cid;
        this.hid = hid;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ContractRequest(long hid, Date startDate, Date endDate) {
        this.hid = hid;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ContractRequest() {
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public long getHid() {
        return hid;
    }

    public void setHid(long hid) {
        this.hid = hid;
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
}
