package com.example.defence.entity;

import javax.persistence.*;
import com.example.defence.entity.OrderitemPK;
@Entity
@Table(name = "orderitem", schema = "ebook", catalog = "")
@IdClass(OrderitemPK.class)
public class Orderitem {
    @EmbeddedId
    private OrderitemPK PK= new OrderitemPK();
    private Integer sales;
    private Double price;

    public Orderitem(int oid, int bid, int sales,double price){
        this.PK = new OrderitemPK(oid,bid);
        this.sales = sales;
        this.price = price;
    }
    public Orderitem(){}
    @Id
    @Column(name = "oid")
    public int getOid() {
        return PK.getOid();
    }

    public void setOid(int oid) {
        this.PK.setOid(oid);
    }

    @Id
    @Column(name = "bid")
    public int getBid() {
        return this.PK.getBid();
    }

    public void setBid(int bid) {
        this.PK.setBid(bid);
    }

    @Basic
    @Column(name = "sales")
    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orderitem that = (Orderitem) o;

        if (PK != that.PK) return false;
        if (sales != null ? !sales.equals(that.sales) : that.sales != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = this.PK.getOid();
        result = 31 * result + this.PK.getBid();
        result = 31 * result + (sales != null ? sales.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
