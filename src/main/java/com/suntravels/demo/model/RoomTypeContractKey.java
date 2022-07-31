package com.suntravels.demo.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RoomTypeContractKey implements Serializable {

    @Column(name = "room_type_id")
    private long rid;

    @Column(name = "contract_id")
    private long cid;

    public RoomTypeContractKey(long rid, long cid) {
        this.rid = rid;
        this.cid = cid;
    }

    public RoomTypeContractKey() {
    }

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomTypeContractKey that = (RoomTypeContractKey) o;
        return rid == that.rid && cid == that.cid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rid, cid);
    }
}
