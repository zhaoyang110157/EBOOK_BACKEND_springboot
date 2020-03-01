package com.example.defence.entity;

import javax.persistence.*;
import java.io.Serializable;

public class OrderitemPK implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "oid")
    private int oid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bid")
    private int bid;

    public OrderitemPK(int oid,int bid){
        this.bid=bid;
        this.oid=oid;
    }
    public OrderitemPK(){}
    @Column(name = "oid")
    @Id
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    @Column(name = "bid")
    @Id
    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderitemPK that = (OrderitemPK) o;

        if (oid != that.oid) return false;
        if (bid != that.bid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = oid;
        result = 31 * result + bid;
        return result;
    }
}
