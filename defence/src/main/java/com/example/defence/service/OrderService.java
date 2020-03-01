package com.example.defence.service;

import com.example.defence.entity.Orders;

import java.util.List;

public interface OrderService {
    void addOrder(Orders orders);

    List<Orders> getAllById(int id);

    Orders getOne(int oid);
    long getOid();

}
