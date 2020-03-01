package com.example.defence.dao;

import com.example.defence.entity.Orders;

import java.util.List;

public interface OrderDAO {
    void addOrder(Orders orders);

    Orders getOne(int oid);

    List<Orders> getAllById(int id);

    long getOid();
}
